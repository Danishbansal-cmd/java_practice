package stringMatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// kmp
// time complexity (n+m)
public class KnuthMorrisPratt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String pattern = sc.next();

        System.out.println(Arrays.toString(findStringMatchingKMP(text, pattern)));

        sc.close();
    }

    static int[] findStringMatchingKMP(String text, String pattern){
        int n = text.length();
        int m = pattern.length();

        List<Integer> foundIndexes = new ArrayList<>();

        int[] lps = createLPS(m, pattern);
        System.out.println(Arrays.toString(lps));

        int i = 0, j = 0;
        while(i < n){
            if(text.charAt(i) == pattern.charAt(j)){
                i += 1;
                j += 1;
            }

            if(j == m){
                int startingIndex = i - m;
                foundIndexes.add(startingIndex);
                j = lps[j - 1];
            } else{
                if(i < n && text.charAt(i) != pattern.charAt(j)){
                    if(j != 0){
                        j = lps[j - 1];
                    }else{
                        i += 1;
                    }
                }
            }
        }

        int resultLength = foundIndexes.size();
        int[] result = new int[resultLength];
        for(int k = 0; k < resultLength; k++){
            result[k] = foundIndexes.get(k);
        }

        return result;
    }

    // Longest Prefix Suffix array
    static int[] createLPS(int lpsLength, String pattern){
        int[] lps = new int[lpsLength];
        Arrays.fill(lps, 0);

        int i = 1, len = 0;
        while(i < lpsLength){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len += 1;
                lps[i] = len;
                i += 1;
            } else {
                if(len != 0){
                    len = lps[len - 1];
                }else{
                    lps[i] = 0;
                    i += 1;
                }
            }
        }
        return lps;
    }
}
