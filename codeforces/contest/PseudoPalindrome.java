// B. Pseudo Palindrome
// time limit per test2 seconds
// memory limit per test256 megabytes
// You are given an array 𝑎
//  of length 𝑛
//  and a non-negative integer 𝑑
// .

// Is it possible to rearrange 𝑎
//  in such a way that |𝑎𝑖−𝑎𝑛+1−𝑖|≤𝑑
//  for all 𝑖
//  (1≤𝑖≤𝑛
// )?

// Input
// The first line contains an integer 𝑡
//  (1≤𝑡≤1000
// ) — the number of test cases.

// The first line of each test case contains integers 𝑛
//  and 𝑑
//  (1≤𝑛≤2000
// , 0≤𝑑≤109
// ) — the length of 𝑎
//  and the integer 𝑑
// .

// The second line of each test case contains 𝑛
//  integers 𝑎1,𝑎2,…,𝑎𝑛
//  (1≤𝑎𝑖≤109
// ) — the elements of the array 𝑎
// .

// It is guaranteed that the sum of 𝑛
//  over all test cases does not exceed 2000
// .

// Output
// For each test case, output "YES" if it is possible to rearrange 𝑎
// . Otherwise, output "NO". You can output "YES" and "NO" in any case (for example, the strings "yEs", "yes", "Yes" and "YES" will be recognized as a positive response).

// Example
// InputCopy
// 3
// 1 1
// 1
// 2 0
// 1 2
// 2 1000
// 1 2
// OutputCopy
// YES
// NO
// YES
// Note
// In the first test case, the given array is already valid.

// In the second test case, it can be proven that there is no valid rearrangement of 𝑎
// .

// In the third test case, the valid rearrangements are [1,2]
//  and [2,1]
// .

package codeforces.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PseudoPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt(); // Number of test cases

        // Process each test case one by one
        while (intputNumber-- > 0) {
            int n = sc.nextInt();              // Number of elements
            int d = sc.nextInt();              // the difference d to maintain

            ArrayList<Integer> elements = new ArrayList<>();
            for(int i = 0; i < n; i++){
                elements.add(sc.nextInt());
            }
            
            System.out.println(canPossibleArrangePseudo(n, d, elements));
        }

        sc.close(); // Close the Scanner to free resources
    }

    // what are we doing here is that checking after the sorting of the elements,
    // is it possible to pair the elements where |a(base i) - a(base n-i+1)| <= d
    static String canPossibleArrangePseudo(int n, int d, ArrayList<Integer> elements){
        Collections.sort(elements); //sorts the array

        boolean ans = false; // default case false means no solution

        if(n % 2 == 0){ // if even, then good way to find if the pairs are possible
            ans = checkPseudo(d, elements);
        } else { // for the odd case
            for(int i = 0; i < n; i ++){ // remove each index element every time, then check
                ArrayList<Integer> temp = new ArrayList<>(elements);
                temp.remove(i);

                if(checkPseudo(d, temp)){ // even if one case is true then we found our answer
                    ans = true;
                    break;
                }
            }
        }

        return ans ? "YES" : "NO";
    }

    static boolean checkPseudo(int d, ArrayList<Integer> elements){ //
        int n = elements.size();

        for(int i = 0; i + 1 < n; i += 2){
            if(Math.abs(elements.get(i) - elements.get(i + 1)) > d ){ // check condition if not satisfied false return false
                return false;
            }
        }

        return true; // default true, we found solution
    }
}