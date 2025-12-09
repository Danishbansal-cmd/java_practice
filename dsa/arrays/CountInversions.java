package arrays;

import java.util.Arrays;

// https://www.youtube.com/watch?v=AseUmwVNaoY
// this video helped

public class CountInversions {
    public static void main(String[] args) {
        // Example input array
        int[] nums = new int[]{2, 3, 7, 1, 3, 5};

        // Call the countInversions function and print the final total inversions stored in the single-element array
        System.out.println(Arrays.toString(countInversions(nums, 0, nums.length-1)));
    }
    
    /**
     * Main recursive function that implements the Merge Sort algorithm 
     * while counting inversions using a shared counter array.
     * The input array 'nums' is sorted in place as a side effect.
     *
     * @param nums The array being sorted and checked for inversions.
     * @param left The starting index of the current subarray.
     * @param right The ending index of the current subarray.
     * @return A single-element int array containing the total accumulated inversion count.
     */
    static int[] countInversions(int[] nums, int left, int right){
        // A simple array used as a mutable integer wrapper to pass the count by reference across recursive calls.
        int[] countInversions = new int[1];

        // Base case: only proceed if the subarray has more than one element.
        if(left < right){
            // Calculate the middle index to split the array into two halves.
            int mid = left + (right - left)/2;

            // Recursively count inversions in the left half (modifies the shared countInversions array).
            countInversions(nums, left, mid);
            // Recursively count inversions in the right half (modifies the shared countInversions array).
            countInversions(nums, mid + 1, right);

            // Merge the two sorted halves and count inversions that occur across the boundary.
            // The countInversions array is passed by reference to accumulate the total count.
            merge(nums, left, mid, right, countInversions);
        }

        // Return the shared counter array containing the final total count.
        return countInversions;
    }

    /**
     * Merges two sorted subarrays into a single sorted array and updates the inversion count.
     * This is where the core inversion counting logic specific to merge sort resides.
     *
     * @param nums The original array to merge into.
     * @param left The starting index of the first subarray.
     * @param mid The ending index of the first subarray (mid+1 is start of second).
     * @param right The ending index of the second subarray.
     * @param countInversions A shared int array used as a mutable counter.
     */
    static void merge(int[] nums, int left, int mid, int right, int[] countInversions){
        // Calculate the lengths of the two temporary subarrays.
        int l1 = mid - left + 1;
        int l2 = right - mid;

        // Create temporary arrays to hold the data to be merged.
        int[] arr1 = new int[l1];
        int[] arr2 = new int[l2];

        // Copy data from the original array into the temporary left array.
        for(int i = 0; i < l1; i++){
            arr1[i] = nums[left + i];
        }

        // Copy data from the original array into the temporary right array.
        for(int i = 0; i < l2; i++){
            arr2[i] = nums[mid + i + 1];
        }

        // Initialize pointers for the main array (i), the left temp array (j), and the right temp array (k).
        int i = left; // Main array insertion index
        int j = 0;    // Left array index
        int k = 0;    // Right array index

        // Merge the temp arrays back into the original array nums[left...right]
        while(j < l1 && k < l2){
            if(arr1[j] <= arr2[k]){
                // If the element in the left array is smaller or equal, place it first. 
                // No inversions are counted in this case.
                nums[i++] = arr1[j++];
            }else{
                // If the element in the right array is smaller, place it first.
                // This means all remaining elements in the left subarray (from index j to the end) 
                // form an inversion with the current element arr2[k].
                countInversions[0] += (l1 - j);
                nums[i++] = arr2[k++];
            }
        }

        // Copy remaining elements of the left array (if any are left).
        while(j < l1){
            nums[i++] = arr1[j++];
        }

        // Copy remaining elements of the right array (if any are left).
        while(k < l2){
            nums[i++] = arr2[k++];
        }
    }
}
