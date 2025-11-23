// C. Interesting Story
// time limit per test4 seconds
// memory limit per test256 megabytes
// Stephen Queen wants to write a story. He is a very unusual writer, he uses only letters 'a', 'b', 'c', 'd' and 'e'!

// To compose a story, Stephen wrote out 𝑛
//  words consisting of the first 5
//  lowercase letters of the Latin alphabet. He wants to select the maximum number of words to make an interesting story.

// Let a story be a sequence of words that are not necessarily different. A story is called interesting if there exists a letter which occurs among all words of the story more times than all other letters together.

// For example, the story consisting of three words "bac", "aaada", "e" is interesting (the letter 'a' occurs 5
//  times, all other letters occur 4
//  times in total). But the story consisting of two words "aba", "abcde" is not (no such letter that it occurs more than all other letters in total).

// You are given a sequence of 𝑛
//  words consisting of letters 'a', 'b', 'c', 'd' and 'e'. Your task is to choose the maximum number of them to make an interesting story. If there's no way to make a non-empty story, output 0
// .

// Input
// The first line contains one integer 𝑡
//  (1≤𝑡≤5000
// ) — the number of test cases. Then 𝑡
//  test cases follow.

// The first line of each test case contains one integer 𝑛
//  (1≤𝑛≤2⋅105
// ) — the number of the words in the sequence. Then 𝑛
//  lines follow, each of them contains a word — a non-empty string consisting of lowercase letters of the Latin alphabet. The words in the sequence may be non-distinct (i. e. duplicates are allowed). Only the letters 'a', 'b', 'c', 'd' and 'e' may occur in the words.

// It is guaranteed that the sum of 𝑛
//  over all test cases doesn't exceed 2⋅105
// ; the sum of the lengths of all words over all test cases doesn't exceed 4⋅105
// .

// Output
// For each test case, output the maximum number of words that compose an interesting story. Print 0 if there's no way to make a non-empty interesting story.

// Example
// InputCopy
// 6
// 3
// bac
// aaada
// e
// 3
// aba
// abcde
// aba
// 2
// baba
// baba
// 4
// ab
// ab
// c
// bc
// 5
// cbdca
// d
// a
// d
// e
// 3
// b
// c
// ca
// OutputCopy
// 3
// 2
// 0
// 2
// 3
// 2
// Note
// In the first test case of the example, all 3
//  words can be used to make an interesting story. The interesting story is "bac aaada e".

// In the second test case of the example, the 1
// -st and the 3
// -rd words can be used to make an interesting story. The interesting story is "aba aba". Stephen can't use all three words at the same time.

// In the third test case of the example, Stephen can't make a non-empty interesting story. So the answer is 0
// .

// In the fourth test case of the example, Stephen can use the 3
// -rd and the 4
// -th words to make an interesting story. The interesting story is "c bc".







// C. Interesting Story
// -----------------------------------------
// Problem Summary:
// Stephen wants to select the maximum number of words such that
// there exists one letter (among 'a' to 'e') that appears more times
// than *all other letters combined* in the chosen words.
//
// Approach Summary:
// For each letter ('a' to 'e'), calculate how "favorable" each word is
// for that letter using a score function:
//     f(word, letter) = (2 * count(letter)) - word.length()
// Then, sort these scores in descending order and greedily take
// as many words as possible until the total sum of scores becomes
// non-positive. The maximum count among all letters is the answer.

package codeforces.contest;

import java.util.Arrays;
import java.util.Scanner;

// https://codeforces.com/blog/entry/93149
// detailed explanation
public class InterestingStory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt(); // Number of test cases

        // Process each test case
        while (intputNumber-- > 0) {
            int n = sc.nextInt(); // Number of words in this test case
            String[] words = new String[n];

            // Read all words
            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            // Compute and print the maximum number of words
            // that can make an interesting story
            System.out.println(findMaximumCharacterForStory(n, words));
        }

        sc.close();
    }

    /**
     * Finds the maximum number of words that can make an "interesting story".
     * A story is interesting if for some letter 'a'–'e', it appears
     * more times than all other letters combined.
     */
    static int findMaximumCharacterForStory(int n, String[] words) {
        int best = 0; // Store the best (maximum) number of words found for any letter

        // Try each letter from 'a' to 'e' as the potential dominant letter
        for (char ch = 'a'; ch <= 'e'; ch++) {
            int[] score = new int[n]; // Array to store f(word, ch) for each word

            // Compute score for each word with respect to this letter
            for (int j = 0; j < n; j++) {
                int count = 0;
                // Count how many times this letter appears in the word
                for (char c : words[j].toCharArray()) {
                    if (ch == c) count++;
                }
                // f(word, ch) = occurrences_of_ch * 2 - length_of_word
                score[j] = 2 * count - words[j].length();
            }

            // Sort scores in descending order (so we can take best words first)
            Arrays.sort(score);
            reverse(score);

            // Greedily select words while total score remains positive
            int sum = 0;
            int count = 0;
            for (int s : score) {
                sum += s;
                if (sum > 0) count++;  // Still interesting, can add this word
                else break;            // Adding more would make story uninteresting
            }

            // Update best count if this letter allows more words
            best = Math.max(best, count);
        }

        return best;
    }

    /**
     * Utility method to reverse an integer array in place.
     * Used to make score array descending after sorting ascending.
     */
    static void reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = tmp;
        }
    }
}
