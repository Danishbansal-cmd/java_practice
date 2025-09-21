// A. Equal Occurrences
// time limit per test1 second
// memory limit per test256 megabytes

// We call an array balanced if and only if the numbers of occurrences of any of its elements are the same. For example, [1,1,3,3,6,6]
//  and [2,2,2,2]
//  are balanced, but [1,2,3,3]
//  is not balanced (the numbers of occurrences of elements 1
//  and 3
//  are different). Note that an empty array is always balanced.

// You are given a non-decreasing array 𝑎
//  consisting of 𝑛
//  integers. Find the length of its longest balanced subsequence∗
// .

// ∗
// A sequence 𝑏
//  is a subsequence of a sequence 𝑎
//  if 𝑏
//  can be obtained from 𝑎
//  by the deletion of several (possibly, zero or all) element from arbitrary positions.

// Input
// Each test contains multiple test cases. The first line contains the number of test cases 𝑡
//  (1≤𝑡≤500
// ). The description of the test cases follows.

// The first line of each test case contains a single integer 𝑛
//  (1≤𝑛≤100
// ) — the length of 𝑎
// .

// The second line contains 𝑛
//  integers 𝑎1,𝑎2,…,𝑎𝑛
//  (1≤𝑎1≤𝑎2≤⋯≤𝑎𝑛≤𝑛
// ) — the elements of 𝑎
// .

// Output
// For each test case, output a single integer — the length of the longest balanced subsequence of 𝑎
// .


package codeforces.contest;
import java.util.*;

public class EqualOccurences {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();

        for(int i = 0; i < numberOfTestCases; i++){
            int numberOfElements = sc.nextInt();
            int[] elements = new int[numberOfElements];
            for(int j = 0; j < numberOfElements; j++){
                elements[j] = sc.nextInt();
            }

            System.out.println(findLongestBalancedSubsequence(elements));
        }

        sc.close();
    }
    static int findLongestBalancedSubsequence(int[] elements){
        // store the frequency of each element into hashmap
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : elements) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        // make the list of frequencies only
        List<Integer> freqList = new ArrayList<>(freq.values());

        // find the maxFrequency, because each element could not have
        // more elements then maxFrequency
        int maxFrequency = Collections.max(freqList);

        int longestBalancedSubsequence = 0;

        for(int f = 1; f <= maxFrequency; f++){
            // count all the frequencies that are greater then the current f (frequency)
            int count = 0;
            for(int i : freqList){
                if(i >= f) count++;
            }

            // so the max subsequence could be for the current f,
            // the number of "count" elements
            // have minimum of "f" same elements, mean (count * f)
            longestBalancedSubsequence = Math.max(longestBalancedSubsequence, f * count);

        }
        
        return longestBalancedSubsequence;
    }
}
