package sorting;

public class MergeSort {

    // Standard Merge Sort Implementation
    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort left half
            mergeSort(nums, left, mid);

            // Sort right half
            mergeSort(nums, mid + 1, right);

            // Merge the two sorted halves
            merge(nums, left, mid, right);
        }
    }

    // Merge two sorted halves into one
    public static void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy left subarray into L[]
        for (int i = 0; i < n1; i++) {
            L[i] = nums[left + i];
        }

        // Copy right subarray into R[]
        for (int i = 0; i < n2; i++) {
            R[i] = nums[mid + 1 + i];
        }

        // Merge L[] and R[] back into nums[]
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                nums[k++] = L[i++];
            } else {
                nums[k++] = R[j++];
            }
        }

        // Copy remaining elements of L[], if any
        while (i < n1) {
            nums[k++] = L[i++];
        }

        // Copy remaining elements of R[], if any
        while (j < n2) {
            nums[k++] = R[j++];
        }
    }
    
    public static void main(String[] args){
        int[] nums = {5, -3, 4, 8, -32, 88, 1, 0, 4, 3, -45, 32};
        int n = nums.length;
        mergeSort(nums, 0 , n-1);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
