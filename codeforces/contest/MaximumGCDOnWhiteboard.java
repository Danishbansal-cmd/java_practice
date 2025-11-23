// C. Maximum GCD on Whiteboard
// time limit per test2 seconds
// memory limit per test256 megabytes

// You are given an integer 𝑘
//  and 𝑛
//  positive integers 𝑎1,𝑎2,…,𝑎𝑛
//  written on a whiteboard, where 1≤𝑎𝑖≤𝒏
// . You may perform the following operations:

// Erase: Choose an integer from the whiteboard and erase it. This operation can be performed at most 𝑘
//  times.
// Split: Choose an integer 𝑥≥3
//  from the whiteboard. Split it into three positive integers 𝑥1
// , 𝑥2
// , and 𝑥3
//  such that 𝑥1+𝑥2+𝑥3=𝑥
// , and 1≤𝑥1≤𝑥2≤𝑥3
// . Then, erase 𝑥
//  from the whiteboard and write two new integers 𝑥1
//  and 𝑥3
//  on the whiteboard. Note that 𝑥2
//  is discarded and not written on the whiteboard. This operation may be performed any number of times.
// The beauty of a collection of integers 𝑏
//  is defined as the greatest common divisor of all the elements in 𝑏
// . Formally, it is the largest integer 𝑑
//  such that 𝑑
//  divides 𝑥
//  for every 𝑥
//  that is an element of 𝑏
// .

// Your task is to determine the maximum possible beauty of the integers on the whiteboard after performing at most 𝑘
//  Erase operations and any number of Split operations.

// Input
// Each test contains multiple test cases. The first line contains the number of test cases 𝑡
//  (1≤𝑡≤104
// ). The description of the test cases follows.

// The first line of each test case contains two integers 𝑛
//  and 𝑘
//  (1≤𝑛≤2⋅105
// , 0≤𝑘≤𝑛−1
// ) — the number of integers on the whiteboard, and the maximum number of Erase operations allowed.

// The second line of each test case contains 𝑛
//  integers 𝑎1,𝑎2,…,𝑎𝑛
//  (1≤𝑎𝑖≤𝒏
// ) — the integers initially written on the whiteboard.

// It is guaranteed that the sum of 𝑛
//  over all test cases does not exceed 2⋅105
// .

// Output
// For each test case, output a single integer representing the maximum beauty of the elements written on the whiteboard after performing the operations.

// Example
// InputCopy
// 6
// 9 1
// 4 9 6 8 2 6 7 8 2
// 10 1
// 4 9 6 8 2 6 7 8 2 7
// 7 5
// 1 1 2 3 4 5 5
// 7 4
// 1 1 2 3 4 5 5
// 14 3
// 14 12 7 12 9 9 12 4 3 1 3 6 9 13
// 1 0
// 1
// OutputCopy
// 2
// 1
// 5
// 1
// 3
// 1
// Note
// In the first test case, you may perform the following sequence of operations:

// Erase 7
// . The whiteboard now contains the integers [4,9,6,8,2,6,8,2]
// .
// Split 9
//  into three integers 2
// , 3
// , and 4
// . 9
//  is erased from the whiteboard, and two new integers 2
//  and 4
//  are written. The whiteboard now contains the integers [4,2,4⎯⎯⎯⎯⎯⎯,6,8,2,6,8,2]
// .
// Split 8
//  into three integers 2
// , 2
// , and 4
// . 8
//  is erased from the whiteboard, and two new integers 2
//  and 4
//  are written. The whiteboard now contains the integers [4,2,4,6,2,4⎯⎯⎯⎯⎯⎯,2,6,8,2]
//  (It does not matter which 8
//  Split is performed on as the ordering in the array does not matter).
// The beauty of the integers on the whiteboard after the operations is 2
//  as it is the largest number that divides all the integers on the whiteboard (2
// , 4
// , 6
// , and 8
// ). Note that the last operation is unnecessary — the beauty of the integers on the whiteboard after the second operation is already 2
// .

// In the second test case, note that the Erase operation can only remove one occurrence of an integer, even if duplicates exist. Here, we are only able to erase one copy of 7
// , so there will still be one remaining 7
//  on the whiteboard. Hence, we are unable to perform the same sequence of operations as in the first test case.

// In the third test case, we can erase integers 1
// , 1
// , 2
// , 3
// , and 4
// , leaving only [5,5]
//  on the whiteboard. Since both numbers are 5
// , their greatest common divisor is 5
// , and the maximum beauty is 5
// .




package codeforces.contest;

import java.util.Scanner;

// Read this article to understand more or ask gpt to explain the contents of the blog
// https://codeforces.com/blog/entry/147761
public class MaximumGCDOnWhiteboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt();

        for(int i = 0; i < intputNumber; i++){
            int n = sc.nextInt(); // number of numbers
            int k = sc.nextInt(); // maximum number of erase operations one can do
            
            int[] nums = new int[n]; // the number array
            for(int j = 0; j < n; j++){
                nums[j] = sc.nextInt();
            }

            theMaximumGCD(n, k, nums);
        }

        sc.close();
    }

    static void theMaximumGCD(int n, int k, int[] nums){
        
    }
}
