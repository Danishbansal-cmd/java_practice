package codeforces.contest;

import java.util.Arrays;
import java.util.Scanner;

public class FlipFlops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt();

        for (int i = 0; i < intputNumber; i++) {
            int n = sc.nextInt();
            long c = sc.nextLong();
            int k = sc.nextInt();

            int[] monsters = new int[n];
            for (int j = 0; j < n; j++) {
                monsters[j] = sc.nextInt();
            }

            System.out.println(flipFlops(n, c, k, monsters));
        }

        sc.close();
    }

    static long flipFlops(int n, long c, int k, int[] monsters){
        Arrays.sort(monsters);

        for(int j = 0; j < n; j++){
            long needed = Math.max(0, Math.min(k, c - monsters[j]));

            if(k > 0){
                monsters[j] += needed;
            }
            if(monsters[j] <= c){
                c += monsters[j];
            }

            if(needed > 0){
                k -= needed;
            }
        }

        return c;
    }
}
