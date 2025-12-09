package arrays;

import java.util.*;

public class FindRepeatingAndMissingNumber{
    public static void main(String[] args) {
        // Example array where n=5, the range is [1, 5]. 
        // '1' is repeating, and '2' is missing from the ideal sequence [1, 2, 3, 4, 5].
        int[] nums = new int[]{3, 5, 4, 1, 1};

        // Call all implemented methods and print their results
        System.out.println("Brute Force Result: " + Arrays.toString(findRepeatingAndMissingNumberUsingBruteForce(nums)));
        System.out.println("HashMap Result: " + Arrays.toString(findRepeatingAndMissingNumberUsingHashMap(nums)));
        System.out.println("Hash Array Result: " + Arrays.toString(findRepeatingAndMissingNumberUsingHashArray(nums)));
        System.out.println("Mathematical Formula Result: " + Arrays.toString(findRepeatingAndMissingNumberUsingMathematical(nums)));
    }

    /**
     * Finds the repeating and missing numbers using a brute-force approach.
     * Time Complexity: O(n^2) - Nested loops iterate through the array multiple times.
     * Space Complexity: O(1)
     * 
     * @param nums The input array containing numbers from 1 to n, with one repeat and one missing.
     * @return An array where the first element is the repeating number and the second is the missing number.
     */
    static int[] findRepeatingAndMissingNumberUsingBruteForce(int[] nums){
        int n = nums.length;

        int repeating = -1, missing = -1;

        // Iterate through all expected numbers from 1 to n
        for(int i = 1; i <= n; i++){
            int count = 0;
            // For each expected number, count its occurrences in the input array
            for(int j = 0; j < n; j++){
                if(nums[j] == i) count++;
            }

            // If a number appears twice, it's the repeating number
            if(count == 2) repeating = i;
            // If a number appears zero times, it's the missing number
            else if(count == 0) missing = i;

            // Optimization: Stop searching once both numbers are found
            if(repeating != -1 && missing != -1){
                break;
            }
        }

        return new int[]{repeating, missing};
    }

    /**
     * Finds the repeating and missing numbers using a HashMap to store frequencies.
     * Time Complexity: O(n) - Single pass to populate map, single pass to check map.
     * Space Complexity: O(n) - To store the frequency map.
     * 
     * @param nums The input array.
     * @return An array where the first element is the repeating number and the second is the missing number.
     */
    static int[] findRepeatingAndMissingNumberUsingHashMap(int[] nums){
        int n = nums.length;

        // Result array: r[0] for repeating, r[1] for missing
        int[] r = new int[2];
        HashMap<Integer, Integer> m = new HashMap<>();

        // First pass: Count the frequency of each number in the input array
        for(int num : nums){
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        // Second pass: Iterate from n down to 1 to identify the results
        for(int i = n; i >= 1; i--){
            // Check if the expected number exists in our frequency map
            if(m.containsKey(i)){
                // If the count is 2 or more, we found the repeating number
                if(m.get(i) >= 2){
                    r[0] = i;
                }
            }else{
                // If the number is absent from the map, it is the missing number
                r[1] = i;
            }
        }

        return r;
    }

    /**
     * Finds the repeating and missing numbers using a auxiliary frequency array (optimized HashMap approach for specific constraints).
     * This works efficiently because the input numbers are guaranteed to be within the range [1, n].
     * Time Complexity: O(n) - Two linear passes.
     * Space Complexity: O(n) - For the auxiliary hash array.
     * 
     * @param nums The input array.
     * @return An array where the first element is the repeating number and the second is the missing number.
     */
    static int[] findRepeatingAndMissingNumberUsingHashArray(int[] nums){
        int n = nums.length;

        int repeating = -1, missing = -1;
        // Create a frequency array of size n+1 (index 0 is ignored)
        int[] h = new int[n+1];

        // First pass: Increment the count at the corresponding index for each number encountered
        for(int num : nums){
            h[num]++;
        }

        // Second pass: Iterate through the frequency array from index 1 to n
        for(int i = 1; i <= n; i++){
            // If count is 2, it's the repeating number
            if(h[i] == 2){
                repeating = i;
            }
            // If count is 0, it's the missing number
            if(h[i] == 0){
                missing = i;
            }
            // Optimization: Exit loop once both values are found
            if(repeating != -1 && missing != -1){
                break;
            }
        }

        return new int[]{repeating, missing};
    }

    /**
     * Finds the repeating and missing numbers using mathematical formulas based on sum and sum of squares.
     * This method leverages the properties of arithmetic series to achieve O(1) space complexity.
     * Time Complexity: O(n) - Single pass to calculate sums.
     * Space Complexity: O(1) - No extra data structures are used.
     * 
     * @param nums The input array.
     * @return An array where the first element is the repeating number and the second is the missing number.
     */
    static int[] findRepeatingAndMissingNumberUsingMathematical(int[] nums){
        int n = nums.length;

        // Use long to prevent potential integer overflow for large n
        long sum = 0, sum2 = 0;
        // Calculate the expected sum of numbers from 1 to n: Sn = n * (n+1) / 2
        long sn = (n * (n + 1L)) / 2;
        // Calculate the expected sum of squares from 1 to n: S2n = n * (n+1) * (2n+1) / 6
        long s2n = (n * (n + 1L) * (2 * n + 1L)) / 6;

        // Iterate through the given array to calculate actual sums
        for(int num : nums){
            sum += num;
            sum2 += (long)num * num;
        }

        // Equation 1: Sum of actuals - Sum of expecteds = (Repeating - Missing)
        // (R + M + others) - (1 + 2 + ... + n) = R - M
        long val1 = sum - sn; // val1 = R - M
        
        // Equation 2: Sum of squares of actuals - Sum of squares of expecteds = (Repeating^2 - Missing^2)
        // R^2 - M^2 = (R - M) * (R + M)
        long val2 = sum2 - s2n; // val2 = R^2 - M^2

        // Divide Equation 2 by Equation 1 to find (R + M)
        // (R^2 - M^2) / (R - M) = R + M
        val2 = val2 / val1; // val2 now holds R + M

        // We now have a system of linear equations:
        // R - M = val1
        // R + M = val2

        // Add the two equations: 2R = val1 + val2 => R = (val1 + val2) / 2
        int repeating = (int)((val1 + val2) / 2);
        // Substitute R back into the first equation: M = R - val1
        int missing = (int) (repeating - val1);

        return new int[]{repeating, missing};
    }
}
