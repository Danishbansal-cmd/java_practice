package recursion.backtracking;

import java.util.Arrays;

// you are given a string of stickers and the target string
// one can cut out any letter from the stickers and any number of time
// the supply of stickers is unlimited
// return the minimum number of stickers can be used to create the target string
// for little simplicity, all is lowercase

// String[] = ['with','example','science'] target='thehat'
// output: 3
// 2 stickers of 'with' and 1 stciker of 'example'

public class MinimumStickers {
    public static void main(String[] args) {
        // Hardcoded input values
        String[] stickers = {"with", "example", "science"};
        String target = "thehat";

        // Execution
        int result = minimumStickers(stickers, target, target.length());
        
        // Output result
        System.out.println("Stickers: " + Arrays.toString(stickers));
        System.out.println("Target: " + target);
        System.out.println("Minimum stickers needed: " + result);
    }

    static int minimumStickers(String[] stickers, String target, int targetLength){
        int n = stickers.length;
        int[][] stickerCounts = new int[n][26];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < stickers[i].length(); j++){
                int index = stickers[i].charAt(j) - 'a';
                stickerCounts[i][index]++;
            }
        }

        int fullMask = (1 << target.length()) - 1;
        int currentMask = 0;

        return recursion(stickerCounts, currentMask, fullMask, target, targetLength);
    }

    static int recursion(int[][] stickerCounts, int currentMask, int fullMask, String target, int targetLength){
        if(currentMask == fullMask){
            return 0;
        }

        int count = Integer.MAX_VALUE;
        for(int[] stickerArr : stickerCounts){
            int newMask = currentMask;
            for(int i = 0; i < targetLength; i++){
                if((newMask & (i<<i)) == 0){
                    char ch = target.charAt(i);
                    if(stickerArr[ch - 'a'] >= 1){
                        stickerArr[ch - 'a']--;
                        newMask = newMask | (i<<i);
                    }
                }
            }
            if(currentMask!=newMask){
                int res = recursion(stickerCounts, currentMask, fullMask, target, targetLength);
                if(res != -1){
                    count = Math.min(count, res+1);
                }
            }
        }

        if(count == Integer.MAX_VALUE){
            return -1;
        }

        return count;
    }
}
