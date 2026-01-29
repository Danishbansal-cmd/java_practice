// Count subsets with sum K
// Given an array arr of n integers and an integer K, count the number of subsets of the given array that have a sum equal to K. Return the result modulo (109 + 7).


package dynamicProgramming;

// it is the solution to the problem given in this link
// https://takeuforward.org/plus/dsa/problems/count-subsets-with-sum-k

public class CountSubsetsWithSumK {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 16, 8, 10};
        int k = 10;
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        int k2 = 5;
        int[] arr3 = new int[]{1, 1, 4, 5};
        int k3 = 5;
        int[] arr4 = new int[]{1, 2, 3};
        int k4 = 0;

        System.out.println("arr: " + countSubsetsWithSumK(arr, k));        // Expected: 3 ({2,8}, {10}, {2,3,5})
        System.out.println("arr2 k2: " + countSubsetsWithSumK(arr2, k2));  // Expected: 3 ({5}, {2,3}, {1,4})
        System.out.println("arr3 k3: " + countSubsetsWithSumK(arr3, k3));  // Expected: 3 ({5}, {1,4} x2)
        System.out.println("arr4 k4: " + countSubsetsWithSumK(arr4, k4));  // Expected: 1 ({})
    }

    /**
     * Finds the number of subsets that sum up to a specific target 'K'.
     * This is a variation of the 0/1 Knapsack problem.
     * 
     * @param arr    The input array of positive integers.
     * @param target The sum we want to achieve using subsets.
     * @return The total count of distinct subsets that sum to target.
     */
    static int countSubsetsWithSumK(int[] arr, int target) {
        int n = arr.length;

        // dp[i][j] stores the number of subsets using the first 'i' elements 
        // that sum up to value 'j'.
        int[][] dp = new int[n + 1][target + 1];

        // Base Case 1: If target > 0 and we have 0 elements, 0 subsets are possible.
        for (int i = 1; i <= target; i++) {
            dp[0][i] = 0;
        }

        // Base Case 2: If target is 0, there is 1 subset (the empty subset) 
        // that sums to 0, regardless of how many elements we have.
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // If the current element is greater than the current target 'j',
                // we cannot include it in the subset.
                if (arr[i - 1] > j) {
                    // Carry over the number of ways from the previous elements.
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Total ways = (Ways excluding current element) + (Ways including current element)
                    // dp[i - 1][j]: Ways to form sum 'j' without using arr[i-1].
                    // dp[i - 1][j - arr[i - 1]]: Ways to form the remaining sum after using arr[i-1].
                    // Note: We use dp[i-1] for both because each element can be used only once (0/1).
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // The answer is the number of ways to form 'target' using all 'n' elements.
        return dp[n][target];
    }
}
