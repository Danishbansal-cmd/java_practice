// Floor and Ceil in Sorted Array

// Given a sorted array nums and an integer x. 
// Find the floor and ceil of x in nums. The floor of x is the largest element in the array which is smaller than or equal to x. 
// The ceiling of x is the smallest element in the array greater than or equal to x. If no floor or ceil exists, output -1.



package binarySearch;

import java.util.Arrays;

// https://www.youtube.com/watch?v=6zhGS79oQ4k
// this video helped

public class FloorAndCeil {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 4, 6, 7, 8, 10};
        int[] nums2 = new int[]{};
        int[] nums3 = new int[]{3};
        int target = 5;
        int target2 = 8;

        System.out.println(Arrays.toString(getFloorAndCeil(nums, target)));
    }

    /**
     * Helper function to bundle the floor and ceiling results into an array.
     */
    static int[] getFloorAndCeil(int[] nums, int target){
        int findFloor = getFloor(nums, target);
        int findCeil = getCeil(nums, target); // this is lower Bound
        return new int[]{findFloor, findCeil};
    }

    /**
     * Finds the floor of the target: the largest element in the array which is <= target.
     * Returns the VALUE of the floor, or -1 if no such value exists.
     */
    static int getFloor(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        // 'ans' stores the value of the potential floor found so far
        int ans = -1; 

        while(left <= right){
            int search = left + (right - left) / 2;

            if(nums[search] <= target){
                // nums[search] is a potential floor. We store its VALUE.
                // We try to find a larger value that is still <= target in the right subarray.
                ans = nums[search]; 
                left = search + 1;
            } else {
                // nums[search] is too large (greater than target).
                // The floor must be in the left subarray.
                right = search - 1;
            }
        }
        // If the loop finishes, 'ans' holds the best (largest) valid floor value, or -1.
        return ans;
    }

    /**
     * Finds the ceiling of the target: the smallest element in the array which is >= target.
     * Returns the VALUE of the ceiling, or -1 if no such value exists.
     */
    static int getCeil(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        // 'ans' stores the value of the potential ceiling found so far
        int ans = -1;

        while(left <= right){
            int search = left + (right - left) / 2;

            if(nums[search] >= target){
                // nums[search] is a potential ceiling. We store its VALUE.
                // We try to find a smaller value that is still >= target in the left subarray.
                ans = nums[search]; 
                right = search - 1;
            } else {
                // nums[search] is too small (less than target).
                // The ceiling must be in the right subarray.
                left = search + 1;
            }
        }
        // If the loop finishes, 'ans' holds the best (smallest) valid ceiling value, or -1.
        return ans;
    }
}