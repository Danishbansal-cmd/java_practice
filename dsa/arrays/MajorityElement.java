package arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // for detailed explanation
    // https://www.youtube.com/watch?v=nP_ns3uSh80
    public static void main(String[] args) {
        int[] nums = new int[] {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    // ✅ Entry point — choose one approach
    public static int majorityElement(int[] nums) {
        // return hashMapApproach(nums);          // O(n) space, simple to understand
        return mooresVotingAlgorithmApproach(nums);  // O(1) space, optimal solution
    }

    // 🔹 Approach 1: HashMap Counting
    // Time: O(n)
    // Space: O(n)
    static int hashMapApproach(int[] nums) {
        int n = nums.length;
        int result = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        // Step 1️⃣: Count frequency of each number
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        // Step 2️⃣: Find the number whose frequency > n/2
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > n / 2) {
                result = entry.getKey();
                break;
            }
        }

        // Step 3️⃣: Return the majority element
        return result;
    }

    // 🔹 Approach 2: Moore’s Voting Algorithm
    //     The Moore’s Voting Algorithm (also known as Boyer–Moore Majority Vote Algorithm) is used to find the majority element in a sequence —
    // that is, the element that appears more than ⌊ n/2 ⌋ times.
    // Time: O(n)
    // Space: O(1)

    // Applications of the Moore’s Voting Algorithm
    // 🔹 (A) Finding the Majority Element (> n/2 times)
    // Problem:
    // Given an array, find the element that appears more than n/2 times.
    // 🔹 (B) Finding Elements Appearing More Than n/3 Times
    // Extended Version:
    // You can modify the algorithm to find all elements appearing more than ⌊n/3⌋ times.
    // There can be at most 2 such elements
    // Maintain two candidates and two counts
    // ✅ Generalization of Moore’s algorithm.
    // 🔹 (C) Detecting Dominant Opinions in Voting Systems
    // In electronic voting or feedback systems:
    // Each user votes for a candidate or gives a rating.
    // You want to detect if there’s a clear majority preference (> 50%).
    // Moore’s algorithm can efficiently:
    // Process votes in real-time,
    // Using constant space,
    // Without storing the entire dataset.
    

    //
    // Logic:
    // - If we pair each occurrence of the majority element with a different number,
    //   the majority element will still remain at the end.
    // - This algorithm finds a "candidate" that could be the majority element,
    //   then verifies it.
    static int mooresVotingAlgorithmApproach(int[] nums) {
        int n = nums.length;
        int count = 0; // tracks balance between candidate and others
        int candidate = 0;

        // Step 1️⃣: Find potential majority element (candidate)
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                // Choose current number as the new candidate
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                // Same as candidate → increment count
                count++;
            } else {
                // Different number → decrement count
                count--;
            }
        }

        // Step 2️⃣: Verify that candidate actually appears more than n/2 times
        int freq = 0;
        for (int num : nums) {
            if (num == candidate) freq++;
        }

        // Step 3️⃣: Return candidate if valid, else -1 (shouldn't happen for valid inputs)
        if (freq > n / 2) {
            return candidate;
        }

        return -1;
    }
}
