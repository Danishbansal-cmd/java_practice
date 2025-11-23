// D1. Domino (easy version)
// time limit per test1 second
// memory limit per test256 megabytes
// The only difference between this problem and D2 is that you don't have to provide the way to construct the answer in this problem, but you have to do it in D2.

// There's a table of 𝑛×𝑚
//  cells (𝑛
//  rows and 𝑚
//  columns). The value of 𝑛⋅𝑚
//  is even.

// A domino is a figure that consists of two cells having a common side. It may be horizontal (one of the cells is to the right of the other) or vertical (one of the cells is above the other).

// You need to find out whether it is possible to place 𝑛𝑚2
//  dominoes on the table so that exactly 𝑘
//  of them are horizontal and all the other dominoes are vertical. The dominoes cannot overlap and must fill the whole table.

// Input
// The first line contains one integer 𝑡
//  (1≤𝑡≤10
// ) — the number of test cases. Then 𝑡
//  test cases follow.

// Each test case consists of a single line. The line contains three integers 𝑛
// , 𝑚
// , 𝑘
//  (1≤𝑛,𝑚≤100
// , 0≤𝑘≤𝑛𝑚2
// , 𝑛⋅𝑚
//  is even) — the number of rows, columns and horizontal dominoes, respectively.

// Output
// For each test case output "YES", if it is possible to place dominoes in the desired way, or "NO" otherwise.

// You may print each letter in any case (YES, yes, Yes will all be recognized as positive answer, NO, no and nO will all be recognized as negative answer).

// Example
// InputCopy
// 8
// 4 4 2
// 2 3 0
// 3 2 3
// 1 2 0
// 2 4 2
// 5 2 2
// 2 17 16
// 2 1 1
// OutputCopy
// YES
// YES
// YES
// NO
// YES
// NO
// YES
// NO



package codeforces.contest;
import java.util.Scanner;

// https://codeforces.com/blog/entry/93149
// detailed explanation
public class DominoEasyVersion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt(); // Number of test cases

        // Process each test case one by one
        while (intputNumber-- > 0) {
            int rows = sc.nextInt();              // Number of rows (n)
            int cols = sc.nextInt();              // Number of columns (m)
            int horizontalDominoes = sc.nextInt(); // Number of horizontal dominoes required (k)

            // Check if it’s possible to place dominoes in the desired configuration
            canDominoesPlacedDesiredly(rows, cols, horizontalDominoes);
        }

        sc.close(); // Close the Scanner to free resources
    }

    static void canDominoesPlacedDesiredly(int n, int m, int k) {
        // Maximum number of horizontal dominoes that can fit in the grid
        // Each row can have m/2 horizontal dominoes (since each domino occupies 2 columns)
        int mHD = n * (m / 2); 

        // --------------------------
        // Case 1: Both n and m are even
        // --------------------------
        // In a fully even grid, we can freely arrange dominos in pairs.
        // The only restriction is that the number of horizontal dominoes (k) must be even.
        if (n % 2 == 0 && m % 2 == 0) {
            if (k % 2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } 

        // --------------------------
        // Case 2: n is even, m is odd
        // --------------------------
        // When the number of columns is odd, the last column must be filled with vertical dominos.
        // That means we cannot use that column for any horizontal dominos.
        // The rest of the grid (with even number of columns) can be filled normally.
        // Therefore, we just need to check:
        // - k is even (so the grid divides evenly)
        // - k does not exceed the total possible horizontal domino count (mHD)
        else if (n % 2 == 0 && m % 2 == 1) {
            if (k % 2 == 0 && k <= mHD) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } 

        // --------------------------
        // Case 3: n is odd, m is even
        // --------------------------
        // When the number of rows is odd, the last row must be filled with horizontal dominos,
        // because there’s no row below it to place vertical dominos.
        //
        // So, we must have at least (m/2) horizontal dominos for that last row.
        // After filling that row, we remove it from the grid (n-1 rows left).
        // The remaining grid (with even number of rows) must then have an even number of horizontal dominos.
        else if (n % 2 == 1 && m % 2 == 0) {
            if (k < m / 2) {
                // Not enough horizontal dominos to fill the last row
                System.out.println("NO");
            } else {
                // Subtract the dominos used in the last row
                k = k - m / 2;

                // The remaining horizontal dominos should form pairs (even count)
                if (k % 2 == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
