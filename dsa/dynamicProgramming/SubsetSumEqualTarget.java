// Subset sum equals to target
// Given an array arr of n integers and an integer target, determine if there is a subset of the given array with a sum equal to the given target.



package dynamicProgramming;

// This code solves the 'Subset Sum Problem' using a 2D Dynamic Programming approach.
// Problem link: https://takeuforward.org/plus/dsa/problems/subset-sum-equals-to-target
public class SubsetSumEqualTarget {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 7, 3};
        int target = 6;
        int[] arr2 = new int[]{2, 3, 5};
        int target2 = 6;
        int[] arr3 = new int[]{7, 54, 4, 12, 15, 5};
        int target3 = 9;
        int[] arr4 = new int[]{1, 2, 3};
        int target4 = 0;

        // Output results for provided test cases
        System.out.println("arr target: " + subsetSumEqualTarget(arr, target));       // Expected: true ({1, 2, 3})
        System.out.println("arr2 target: " + subsetSumEqualTarget(arr2, target2));    // Expected: false
        System.out.println("arr3 target3: " + subsetSumEqualTarget(arr3, target3));   // Expected: true ({4, 5})
        System.out.println("arr4 target4: " + subsetSumEqualTarget(arr4, target4));   // Expected: true (Empty subset)
    }

    /**
     * Determines if there exists a subset of the given array that sums up exactly to the target.
     * 
     * @param arr    The input array of non-negative integers.
     * @param target The sum we are trying to achieve.
     * @return boolean True if such a subset exists, False otherwise.
     */
    static boolean subsetSumEqualTarget(int[] arr, int target) {
        int n = arr.length;

        // dp[i][j] represents whether it is possible to achieve sum 'j' 
        // using only the first 'i' elements of the array.
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base Case 1: If the number of elements is 0 but the target sum is > 0,
        // it is impossible to form the sum (False).
        for (int i = 1; i <= target; i++) {
            dp[0][i] = false;
        }

        // Base Case 2: If the target sum is 0, it is always possible to form it
        // by choosing an empty subset, regardless of the number of elements available (True).
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the DP table using a bottom-up approach.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // If the value of the current element (arr[i-1]) is greater than 
                // the current target 'j', we cannot include it in our subset.
                if (arr[i - 1] > j) {
                    // Result remains the same as it was without this element.
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // We have two choices for the current element:
                    // 1. Exclude it: Check if the sum 'j' was possible with 'i-1' elements (dp[i-1][j]).
                    // 2. Include it: Check if the sum (j - arr[i-1]) was possible with 'i-1' elements.
                    // If either choice leads to a 'true' result, then dp[i][j] is true.
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // The final answer is stored in the last cell, representing all elements 
        // and the full target sum.
        return dp[n][target];
    }
}
