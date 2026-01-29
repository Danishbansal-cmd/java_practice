package binarySearch;

import java.util.Arrays;

// SOLVED IT ON GFG BECAUSE LEETCODE ASKED FOR PREMIUM FOR THIS QUESTION
// https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/1
// https://leetcode.com/problems/minimize-max-distance-to-gas-station/

public class MinimizeMaxDistance {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k1 = 9;
        int[] nums2 = new int[]{1, 2, 3, 4, 5};
        int k2 = 20;
        int[] nums3 = new int[]{1, 3, 4, 6, 11, 13};
        int k3 = 30;
        int[] nums4 = new int[]{1, 2};
        int k4 = 1000000;
        int[] nums5 = new int[]{1, 3, 4, 5};
        int k5 = 2;

        System.out.println("Input: " + Arrays.toString(nums1) + " output: " + minMaxDist(nums1, k1));
        System.out.println("Input: " + Arrays.toString(nums2) + " output: " + minMaxDist(nums2, k2));
        System.out.println("Input: " + Arrays.toString(nums3) + " output: " + minMaxDist(nums3, k3));
        System.out.println("Input: " + Arrays.toString(nums4) + " output: " + minMaxDist(nums4, k4));
        System.out.println("Input: " + Arrays.toString(nums5) + " output: " + minMaxDist(nums5, k5));

    }

        /**
     * Finds the minimum possible maximum distance between adjacent gas stations 
     * after adding K additional stations using a binary search on the answer.
     * 
     * @param stations Sorted array of existing gas station positions
     * @param K The number of additional stations to be added
     * @return The minimized maximum distance, rounded to two decimal places
     */
    static double minMaxDist(int[] stations, int K) {        
        // The smallest possible maximum distance is 0
        double left = 0;
        // The largest possible maximum distance is the total range of the stations
        double right = stations[stations.length - 1] - stations[0];
        
        // Precision threshold for the binary search on a floating-point range
        double epsilon = 0.0001;
        
        while((right - left) > epsilon){
            double mid = left + (right - left) / 2;

            // Determine how many new stations are needed to ensure the gap between 
            // any two adjacent stations is at most 'mid'.
            int insertedStations = numberOfInsertedStationWithThisMidDiff(stations, mid);
            
            // If the number of stations required is less than or equal to our allowed limit K,
            // it means 'mid' is a feasible maximum distance. We then try to find an 
            // even smaller maximum distance by searching in the left half (lower values).
            if(insertedStations <= K){
                right = mid;
            } else {
                // If we need more than K stations, 'mid' is too small of a gap to maintain
                // with our limited budget of stations. We must increase our target distance.
                left = mid;
            }
        }
        
        // Return the result rounded to 2 decimal places
        return Math.round(left * 100.0) / 100.0;
    }
    
    /**
     * Calculates the total number of stations required to be inserted between 
     * existing stations so that no two adjacent stations are further than 'mid' apart.
     * 
     * @param stations Sorted array of existing gas station positions
     * @param mid The maximum allowable distance between stations
     * @return The total count of stations needed to satisfy the distance constraint
     */
    static int numberOfInsertedStationWithThisMidDiff(int[] stations, double mid){
        int count = 0;
        
        for(int i = 0; i < stations.length - 1; i++){
            // Calculate how many segments of length 'mid' fit into the current gap.
            // Using (dist / mid) gives the number of internal points needed.
            // Example: gap of 10 with mid 3.5 -> 10/3.5 = 2.85 -> 2 stations needed.
            count += (int) (stations[i+1] - stations[i] * 1.0)/mid;
        }
        
        return count;
    }

}
