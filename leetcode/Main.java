package leetcode;
import java.util.*;

public class Main {

    static int minRemoval(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++)
            dp[i][i] = 1;

        for(int len = 2; len <= n; len++) {

            for(int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                // remove arr[i] separately
                dp[i][j] = 1 + dp[i + 1][j];

                // merge equal values
                for(int k = i + 1; k <= j; k++) {

                    if(arr[i] == arr[k]) {

                        int middle =
                            (k == i + 1)
                            ? 0
                            : dp[i + 1][k - 1];

                        int right =
                            (k == j)
                            ? 0
                            : dp[k + 1][j];

                        dp[i][j] =
                            Math.min(dp[i][j],
                                     middle + right);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0){

            int N = sc.nextInt();

            int[] arr = new int[N];

            for(int i=0;i<N;i++)
                arr[i] = sc.nextInt();

            System.out.println(minRemoval(arr));
        }
    }
}