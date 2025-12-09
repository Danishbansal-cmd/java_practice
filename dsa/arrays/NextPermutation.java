package arrays;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5 };

        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    // this video helped me to understand the concept for next Permutation
    // https://www.youtube.com/watch?v=JDOXKqF60RQ
    /**
     * Rearranges numbers in the input array to the lexicographically next greater
     * permutation.
     * If no greater permutation exists (the array is in descending order), it
     * rearranges
     * the array into the lowest possible order (ascending order).
     * The operation must be in-place using only constant extra memory.
     * 
     * @param nums The integer array to be modified.
     */
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        // Find the first index 'index' from the right where nums[index] < nums[index +
        // 1].
        // This is the pivot point where the descending suffix ends.
        int index = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // If no such index is found, the array is already the largest permutation
        // (descending order).
        // In this case, reverse the entire array to get the smallest permutation
        // (ascending order).
        if (index == -1) {
            reverseArray(nums, 0, n - 1);
            return;
        }

        // Otherwise, find the smallest element in the right sub-array (suffix) that is
        // greater than nums[index].
        // The suffix is guaranteed to be in descending order.
        for (int i = n - 1; i >= index; i--) {
            if (nums[i] > nums[index]) {
                // Swap the found element with nums[index] to make the number larger at this
                // pivot point.
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        // Reverse the reamining array to the right of the original 'index' position.
        // This minimizes the change and ensures the suffix is in the lowest possible
        // order (ascending).
        reverseArray(nums, index + 1, n - 1);
    }

    /**
     * Helper method to reverse a portion of the array in-place.
     * 
     * @param nums  The array.
     * @param start The starting index of the portion to reverse.
     * @param end   The ending index of the portion to reverse.
     */
    static void reverseArray(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
