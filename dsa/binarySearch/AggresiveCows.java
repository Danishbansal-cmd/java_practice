package binarySearch;

import java.util.Arrays;

public class AggresiveCows {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 4, 7, 10, 9};
        int n1 = 6, k1 = 4;
        int[] nums2 = new int[]{4, 2, 1, 3, 6};
        int n2 = 5, k2 = 2;
        int[] nums3 = new int[]{10, 1, 2, 7, 5};
        int n3 = 5, k3 = 3;
        int[] nums4 = new int[]{4, 2, 1, 3, 6};
        int n4 = 5, k4 = 2;
        int[] nums5 = new int[]{2, 12, 11, 3, 26, 7};
        int n5 = 6, k5 = 6;

        System.out.println("nums, n1, k1: " + aggresiveCows(n1, k1, nums));
        System.out.println("nums2, n2, k2: " + aggresiveCows(n2, k2, nums2));
        System.out.println("nums3, n3, k3: " + aggresiveCows(n3, k3, nums3));
        System.out.println("nums4, n4, k4: " + aggresiveCows(n4, k4, nums4));
        System.out.println("nums5, n5, k5: " + aggresiveCows(n5, k5, nums5));
    }

    static int aggresiveCows(int n, int k, int[] nums){
        Arrays.sort(nums);

        int left = 0;
        int right = nums[n - 1] - nums[0];

        int maxDistanceBetweenCows = Integer.MIN_VALUE;

        while(left <= right){
            int midDistance = left + (right - left) / 2;

            if(ifCurrentMidDistancePossible(midDistance, n, k, nums)){
                maxDistanceBetweenCows = Math.max(maxDistanceBetweenCows, midDistance);
                left = midDistance + 1;
            }else{
                right = midDistance - 1;
            }
        }

        return maxDistanceBetweenCows;
    }

    static boolean ifCurrentMidDistancePossible(int distance, int n, int k, int[] nums){
        int cowsPlaced = 1;
        int lastCowPlacedIndex = 0;
        for(int i = 1; i < n; i++){
            if((nums[i] - nums[lastCowPlacedIndex]) >= distance){
                cowsPlaced++;
                lastCowPlacedIndex = i;
            }
            if(cowsPlaced == k){
                break;
            }
        }

        return cowsPlaced == k;
    }
}
