// A. Cyclic Merging
// time limit per test2 seconds
// memory limit per test256 megabytes

// You are given 𝑛
//  non-negative integers 𝑎1,𝑎2,…,𝑎𝑛
//  arranged on a ring. For each 1≤𝑖<𝑛
// , 𝑎𝑖
//  and 𝑎𝑖+1
//  are adjacent; 𝑎1
//  and 𝑎𝑛
//  are adjacent.

// You need to perform the following operation exactly 𝑛−1
//  times:

// Choose any pair of adjacent elements on the ring, let their values be 𝑥
//  and 𝑦
// , and merge them into a single element of value max(𝑥,𝑦)
//  with cost max(𝑥,𝑦)
// .
// Note that this operation will decrease the size of the ring by 1
//  and update the adjacent relationships accordingly.

// Please calculate the minimum total cost to merge the ring into one element.

// Input
// Each test contains multiple test cases. The first line contains the number of test cases 𝑡
//  (1≤𝑡≤104
// ). The description of the test cases follows.

// The first line of each test case contains an integer 𝑛
//  (2≤𝑛≤2⋅105
// ).

// The following line contains 𝑛
//  integers 𝑎1,𝑎2,…,𝑎𝑛
//  (0≤𝑎𝑖≤109
// ).

// It is guaranteed that the sum of 𝑛
//  over all test cases does not exceed 2⋅105
// .

// Output
// For each test case, please print a single integer — the minimum total cost.

// Example
// InputCopy
// 3
// 4
// 1 1 3 2
// 2
// 0 2
// 7
// 1 1 4 5 1 4 1
// OutputCopy
// 6
// 2
// 19

package codeforces.contest;

import java.util.Scanner;

public class CyclicMerging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt(); // Number of test cases

        // Process each test case
        while (intputNumber-- > 0) {
            int n = sc.nextInt(); // size of ring array
            
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            // 
            System.out.println(minimumTotalCostToMerge(n, arr));
        }

        sc.close();
    }

    static int minimumTotalCostToMerge(int n, int[] arr){
        int[] frontMax = new int[n];
        frontMax[n-1] = Math.max(arr[n-1], arr[0]);
        for(int i = 0; i < n-1; i++){
            frontMax[i] = Math.max(arr[i], arr[i + 1]);
        }

        int[] backMax = new int[n];
        backMax[0] = Math.max(arr[0], arr[n-1]);
        for(int i = n-1; i > 0; i--){
            backMax[i] = Math.max(arr[i], arr[i - 1]);
        }

        int result = 0;
        for(int i = 0; i < n - 1; i++){
            result += Math.min(frontMax[i], backMax[i]);
            
        }
        return 0;
    }
}
