// B. Abraham's Great Escape
// time limit per test1.5 seconds
// memory limit per test256 megabytes

// Abraham is a brave explorer who goes where no other programmer has gone before. For his next expedition, he plans to investigate a peculiar maze. He knows that the maze is an 𝑛×𝑛
//  grid with an arrow in each cell that points in one of four directions: up, down, left and right. Abraham also knows that if he stands on an arrow, he will be forced to follow the arrows starting from that cell. Each arrow moves Abraham exactly 1
//  cell in the direction that it is pointing. If he reaches an arrow that points towards the outside of the maze, Abraham will escape the maze.

// Abraham doesn't know how the arrows are arranged, so he wants to plan for multiple scenarios. He tasks you with finding an arrangement of arrows in the grid such that there are exactly 𝑘
//  starting cells from which he can escape the maze.

// Input
// Each test contains multiple test cases. The first line contains the number of test cases 𝑡
//  (1≤𝑡≤1000
// ). The description of the test cases follows.

// The only line of each test case contains two integers 𝑛
// , 𝑘
//  (2≤𝑛≤100
// , 0≤𝑘≤𝑛2
// ) — the size of the grid and the number of cells from which Abraham should be able to escape.

// It is guaranteed that the sum of 𝑛2
//  over all test cases does not exceed 105
// .

// Output
// For each test case, do one of the following:

// If there exists a grid satisfying the requirement, print YES and then print 𝑛
//  lines with 𝑛
//  characters in each line indicating the direction of the arrows. Each character should be one of U (up), R (right), L (left), or D (down).
// Otherwise, declare that the task is impossible by printing NO.
// If there are multiple solutions, print any of them.

// You can output the answer in any case (upper or lower). For example, the strings "yEs", "yes", "Yes", and "YES" will be recognized as positive responses.






package codeforces.contest;

import java.util.Scanner;

public class AbrahamsGreatEscape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();

        for(int i = 0; i < numberOfTestCases; i++){
            int gridSize = sc.nextInt();
            int escapePoints = sc.nextInt();

            System.out.println(findPossibleAbrahamsGreatEscape(gridSize, escapePoints));
        }

        sc.close();
    }

    public static int findPossibleAbrahamsGreatEscape(int grid, int k){

        return 0;
    }
}
