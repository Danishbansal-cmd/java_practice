package codeforces.contest;

import java.util.HashSet;
import java.util.Scanner;

// contest/2209/problem/E
public class TrivialStringProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt();

        for (int i = 0; i < intputNumber; i++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            String s = sc.next();
            int[][] queries = new int[q][2];
            for(int j = 0; j < q; j++){
                queries[j][0] = sc.nextInt();
                queries[j][1] = sc.nextInt();
            }

            int[] result = trivialStringProblem(n, q, s, queries);
            for(int k = 0; k < q; k++){
                System.out.println(result[k]);
            }
        }

        sc.close();
    }

    static int[] trivialStringProblem(int n, int q, String s, int[][] queries){
        int[] result = new int[q];
        HashSet<String> st = new HashSet<>();
        String cur = "";
        for(int i = 0; i < n; i++){
            
            if(!st.contains(cur)){
                st.add(cur);
                // cur
            }
        }
        return result;
    }
}
