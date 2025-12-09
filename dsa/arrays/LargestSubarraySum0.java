package arrays;

import java.util.HashMap;

public class LargestSubarraySum0 {
    public static void main(String[] args) {
        int[] nums = new int[]{15, -2, 2, -8, 1, 7, 10, 23};

        // Call the updated method and store the results
        int[] result = largestSubarraySum0(nums);
        int length = result[0];
        int start = result[1];
        int end = result[2];

        System.out.println("Largest Subarray Length: " + length);
        if (length > 0) {
            System.out.println("Start Index: " + start);
            System.out.println("End Index: " + end);
        }
    }

    /**
     * Finds the length, start index, and end index of the largest subarray with a sum of 0.
     * @param nums The input array.
     * @return An integer array where:
     *         index 0 is the length of the largest subarray,
     *         index 1 is the start index,
     *         index 2 is the end index.
     */
    static int[] largestSubarraySum0(int[] nums){
        int n = nums.length;

        // Map to store the first occurrence of a prefix sum
        HashMap<Integer, Integer> h = new HashMap<>();
        int sum = 0;

        int largestSubarraySum0Length = 0;
        int startIndex = -1, endIndex = -1; // Use clear names for start/end indices

        for(int i = 0; i < n; i++){
            int current = nums[i];
            sum += current;

            // Handle the case where the cumulative sum is 0 right from the start (or index 0)
            if(sum == 0){
                if (i + 1 > largestSubarraySum0Length) { // Check if this new length is better
                    largestSubarraySum0Length = i + 1; // Length is i + 1
                    startIndex = 0;
                    endIndex = i;
                }
            }
            // If the sum has been seen before
            else if(h.containsKey(sum)){
                int prevIndex = h.get(sum);
                int currentLength = i - prevIndex;

                if (currentLength > largestSubarraySum0Length) { // Check if this new length is better
                    largestSubarraySum0Length = currentLength;
                    startIndex = prevIndex + 1; // The subarray starts from the element *after* the previous occurrence
                    endIndex = i;
                }
            }
            // Store the first occurrence of this sum
            else{
                h.put(sum, i);
            }
            // Note: The original logic had the `if(sum == 0)` check inside the loop *after* the `else` block which was incorrect.
            // When sum == 0, we want to prioritize that as a valid zero-sum subarray starting from index 0.
        }
        
        // Return an array containing the length, start, and end indices
        return new int[]{largestSubarraySum0Length, startIndex, endIndex};
    }
}
