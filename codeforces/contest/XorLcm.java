// C. XOR LCM
// time limit per test2 seconds
// memory limit per test256 megabytes
// You are given a positive integer 𝑐(1≤𝑐≤107)
// .

// You need to find two positive integers 𝑎
//  and 𝑏
//  such that:

// 1≤𝑎,𝑏≤1017
// (𝑎⊕𝑐)+(𝑏⊕𝑐)=𝑙𝑐𝑚(𝑎,𝑐)+𝑙𝑐𝑚(𝑏,𝑐)
// , where ⊕
//  is the bitwise XOR operator and 𝑙𝑐𝑚(𝑥,𝑦)
//  is the lowest common multiple of 𝑥
//  and 𝑦
// .
// It can be proven that it is always possible to find 𝑎
//  and 𝑏
//  for the given constraints.

// Input
// Each test contains multiple test cases. The first line contains a single integer 𝑡
//  (1≤𝑡≤2⋅105
// ) — the number of test cases. The description of the test cases follows.

// The only line of each test case contains an integer 𝑐
//  (1≤𝑐≤107
// ).

// Output
// For each test case, output two integers 𝑎
//  and 𝑏
// .

// Example
// InputCopy
// 3
// 1
// 2
// 7
// OutputCopy
// 88 71
// 80 62
// 1 35

package codeforces.contest;

import java.util.Scanner;


// watch this video for full explanation
// https://www.youtube.com/watch?v=0Niw7_9RI6U
public class XorLcm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt(); // Number of test cases

        // Process each test case one by one
        while (intputNumber-- > 0) {
            long c = sc.nextLong();

            long a = c;
            long b = c << 30;

            System.out.println(a);
            System.out.println(b);
        }

        sc.close(); // Close the Scanner to free resources
    }
}
