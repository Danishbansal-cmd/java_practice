package arrays;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums));
    }

    // Main method to find the maximum subarray sum
    public static int maxSubArray(int[] nums) {
        // return logic1(nums); // Approach 1: Simple running-sum logic
        return logic2(nums); // Approach 2: Optimized DP-based Kadane’s Algorithm
    }

    // ---------------------------------------------------------------------------
    // 🔹 Approach 1: Running Sum (Basic Kadane’s Algorithm)
    // ---------------------------------------------------------------------------
    //
    // Logic:
    // - Maintain a running sum (`sum`) of the current subarray.
    // - If sum becomes negative, reset it to 0 — because a negative sum will
    // reduce the overall sum of any future subarray.
    // - Keep track of the maximum sum (`max`) seen so far.
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    //

    // Applications of Kadane's Algorithm
    // 🔹 (A) Maximum Subarray Sum (Classic Application)
    // Problem:
    // Find the contiguous subarray (within a one-dimensional array) which has the largest sum.
    // Used in:
    // Financial analysis (finding best profit interval)
    // 🔹 (B) Maximum Circular Subarray Sum
    // Problem:
    // When the array is circular (wrap-around allowed), find the maximum subarray sum.
    // 🔹 (C) Maximum Profit in Stock Trading (Single Transaction)
    // Problem:
    // Given daily stock prices, find the maximum profit from one buy and one sell.
    // Transform:
    // Convert price differences to “daily gains/losses” → Apply Kadane’s algorithm!
    // 🔹 (E) Longest Positive Subarray / Contiguous Positive Trend
    // Problem:
    // Find the longest continuous positive (or improving) sequence.

    
    static int logic1(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE; // Tracks maximum subarray sum found so far
        int sum = 0; // Running sum of current subarray

        for (int i = 0; i < n; i++) {
            sum += nums[i]; // Add current element to the running sum

            // Update max if current sum is greater
            if (sum > max) {
                max = sum;
            }

            // If running sum becomes negative, reset it to 0
            // because continuing with a negative sum will reduce future sums
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    // ---------------------------------------------------------------------------
    // 🔹 Approach 2: DP-style Kadane’s Algorithm (Elegant & Compact)
    // ---------------------------------------------------------------------------
    //
    // Logic:
    // - Define:
    // cs = current subarray sum ending at index i
    // ms = maximum subarray sum found so far
    //
    // - Recurrence relation:
    // cs = max(nums[i], cs + nums[i])
    // ms = max(ms, cs)
    //
    // Meaning:
    // - Either start a new subarray at nums[i],
    // OR extend the previous subarray by adding nums[i].
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    //
    static int logic2(int[] nums) {
        int n = nums.length;

        // Initialize currentSum (cs) and maxSum (ms)
        // Both start as the first element (since array has at least one element)
        int cs = nums[0]; // Current subarray sum ending at current index
        int ms = nums[0]; // Maximum subarray sum found so far

        // Iterate from second element onwards
        for (int i = 1; i < n; i++) {
            int num = nums[i];

            // Step 1️⃣: Decide whether to start a new subarray at nums[i],
            // or to continue the existing one by adding nums[i]
            cs = Math.max(num, cs + num);

            // Step 2️⃣: Update the global maximum if needed
            ms = Math.max(ms, cs);
        }

        // Step 3️⃣: Return the maximum subarray sum
        return ms;
    }

}
