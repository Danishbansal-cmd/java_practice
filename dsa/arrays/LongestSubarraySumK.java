package arrays;

import java.util.HashMap;

// Sub-array: it is the contiguous sub-part of the array
// 

public class LongestSubarraySumK {
    public static void main(String[] args) {
        int[] nums1 = {10, 5, 2, 7, 1, 9};
        System.out.println("Test → Expected: 4 → Got: " + longestSubarraySumKPositiviesOnly(nums1, 15));


        int[] nums8 = {1, -1, 5, -2, 3};
        System.out.println("bruteForceSolution: Test Negative → Expected: 4 → Got: " + bruteForceSolution(nums8, 3));
        System.out.println("longestSubarraySumK: Test Negative → Expected: 4 → Got: " + longestSubarraySumK(nums8, 3));
        System.out.println("longestSubarraySumKPositiviesOnly: Test Negative → Expected: 4 → Got: " + longestSubarraySumKPositiviesOnly(nums8, 3));

        
    }

    // it uses the approach of the two pointers where the sum is increasing
    // and then start reducing it when it exceeds the Specific Value K, until it 
    // becomes equal or less than the Specific Value K
    // it works for only the positives, its time complexity is (O(2n))
    static int longestSubarraySumKPositiviesOnly(int[] nums, int value){
        int n = nums.length;
        int result = 0;

        int i = 0, j = 0;
        int total = 0;
        while(j < n){
            total += nums[j];

            while(i < n && total > value){
                total -= nums[i];
                i++;
            }

            if(total == value){
                result = Math.max(result, j - i + 1);
            }
            j++;
        }

        return result;
    }

    // Function to find the length of the longest subarray with sum equal to a given value (K)
    // it works with the negatives as well as the positives also.
    static int longestSubarraySumK(int[] nums, int value) {
        // HashMap to store prefix sum and its earliest index
        HashMap<Integer, Integer> mp = new HashMap<>();

        int sum = 0;      // To store the cumulative sum at each point
        int maxLen = 0;   // To keep track of the maximum subarray length found

        // Traverse through the array
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];  // Add current element to the running sum

            // Case 1: If the sum itself equals the desired value,
            // the subarray starts from index 0 to i
            if (sum == value) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // Calculate the remaining sum that would make up the target value
            int remaining = sum - value;

            // Case 2: If this remaining sum has been seen before,
            // it means the subarray between that index + 1 and i sums to 'value'
            if (mp.containsKey(remaining)) {
                maxLen = Math.max(maxLen, i - mp.get(remaining) + 1);
            }
            // Store the sum with its index only if it’s not already present,
            // because we want the earliest (leftmost) index for maximum length
            else {
                mp.put(sum, i);
            }
        }

        // Return the maximum length of subarray found
        return maxLen;
    }

    static int bruteForceSolution(int[] nums, int value){
        int n = nums.length;
        int result = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int total = 0;
                for(int k = i; k <= j; k++){
                    total += nums[k];
                }

                // Check if sum == target
                if (total == value) {
                    // Update longest length
                    result = Math.max(result, j - i + 1);
                    // System.out.print("Subarray: [ ");
                    // for (int k = i; k <= j; k++) {
                    //     System.out.print(nums[k] + " ");
                    // }
                    // System.out.println("]");
                }
            }
        }
        
        return result;
    }
}
