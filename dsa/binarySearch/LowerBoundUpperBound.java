// Lower Bound


// Given a sorted array of nums and an integer x, write a program to find the lower bound of x.

// The lower bound algorithm finds the first and smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.

// If no such index is found, return the size of the array.

// Examples:
// Input : nums= [1,2,2,3], x = 2

// Output:1

// Explanation:

// Index 1 is the smallest index such that arr[1] >= x.

// Input : nums= [3,5,8,15,19], x = 9

// Output: 3

// Explanation:

// Index 3 is the smallest index such that arr[3] >= x.



package binarySearch;

public class LowerBoundUpperBound {
    public static void main(String[] args) {
        int[] nums = new int[]{0,3,5,8,15,19};
        int[] nums2 = new int[]{1,2,2,3};
        int[] nums3 = new int[]{0, 4, 6, 7, 8, 31, 56, 78};
        int x = 9;
        int x2 = 2;
        int x3 = 88;

        System.out.println(lowerBound(nums2, x2));
        System.out.println(upperBound(nums3, x3));
    }

    static int lowerBound(int[] nums, int x){
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int ans = n;

        while(left <= right){
            int search = left + (right - left) / 2;

            if(nums[search] >= x){
                ans = search;
                right = search - 1;
            }else{
                left = search + 1;
            }
        }

        return ans;
    }


    /**
     * Finds the Upper Bound: The index of the first element strictly greater than x.
     * In a sorted array, this index also represents the total count of elements 
     * that are less than or equal to x.
     */
    static int upperBound(int[] nums, int x) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        /* 
        * Why we take ans = n:
        * 1. Default Case: If all elements in the row are less than or equal to 'x', 
        *    the 'if(nums[search] > x)' condition will never be met. In this case, 
        *    the count of elements <= x is the entire row (n).
        * 2. Boundary: 'n' is the first index out of bounds, representing that 
        *    no element in the current range is greater than 'x'.
        */
        int ans = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the current element is greater than x, it could be our answer
            if (nums[mid] > x) {
                ans = mid;         // Found a candidate for upper bound
                right = mid - 1;   // Look for an even smaller index on the left
            } else {
                // If current element is <= x, the upper bound must be further right
                left = mid + 1;
            }
        }

        return ans;
    }
}
