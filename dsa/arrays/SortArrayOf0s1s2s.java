package arrays;

import java.util.Arrays;

public class SortArrayOf0s1s2s {

    // for detailed explanation
    // https://www.youtube.com/watch?v=tp8JIuCXBaU&feature=youtu.be
    public static void main(String[] args) {
        int[] nums = new int[] {2,0,2,1,1,0};

        // sort the array
        sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }

    // 🏳️‍🌈 Sort Colors using the Dutch National Flag Algorithm
    // Problem: Given an array with 0s, 1s, and 2s, sort them in-place so that
    // all 0s come first, then 1s, then 2s (i.e., sort colors Red, White, Blue).


    // Applications of the Dutch National Flag Algorithm
    // 🔹 (A) Sorting Arrays with Three Distinct Values
    // This is the most direct and famous application.
    // Used for:
    // Sorting arrays containing {0,1,2}
    // Sorting balls of three colors (Red, White, Blue) — the original problem statement
    // 🔹 (C) Segregating Positive, Negative, and Zero Values
    // You can adapt DNF to separate:
    // Negative numbers → left
    // Zeros → middle
    // Positive numbers → right
    // Used in:
    // Data cleaning pipelines
    // Numerical array rearrangement problems
    // 🔹 (E) RGB Image or Object Categorization (Computer Vision)
    // In image processing:
    // You might need to classify pixels into 3 intensity categories (e.g., dark, neutral, bright).
    // DNF can help you efficiently segment such pixels in-place.
    // Used in:
    // Image segmentation
    // Color quantization (grouping RGB colors into discrete bins)
    // Region labeling (grouping pixels by intensity)

    public static void sortColors(int[] nums) {
        int n = nums.length;

        // 'low' → boundary for 0s (red region)
        // 'mid' → current element under consideration
        // 'high' → boundary for 2s (blue region)


        // 0 to low - 1 (0's region)
        // low to mid - 1 (1's region)
        // mid to high (unsorted region)
        // high + 1 to n - 1 (2's region)
        int low = 0;
        int mid = 0;
        int high = n - 1;

        // Loop until mid crosses high
        while (mid <= high) {
            int num = nums[mid]; // current element being checked

            // Case 1️⃣: Current element is 0
            // Swap it into the 'low' region and expand both 'low' and 'mid'
            if (num == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }

            // Case 2️⃣: Current element is 1
            // It's already in the correct middle region, just move 'mid' forward
            else if (num == 1) {
                mid++;
            }

            // Case 3️⃣: Current element is 2
            // Swap it into the 'high' region and shrink 'high'
            // Do NOT increment 'mid' yet — the new value swapped from 'high'
            // still needs to be examined
            else { // num == 2
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
