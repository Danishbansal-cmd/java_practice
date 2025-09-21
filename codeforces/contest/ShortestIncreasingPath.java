// A. Shortest Increasing Path
// time limit per test1 second
// memory limit per test256 megabytes
// You are at (0,0)
//  in a rectangular grid and want to go to (𝑥,𝑦)
// .

// In order to do so, you are allowed to perform a sequence of steps.

// Each step consists of moving a positive integer amount of length in the positive direction of either the 𝑥
//  or the 𝑦
//  axis.

// The first step must be along the 𝑥
//  axis, the second along the 𝑦
//  axis, the third along the 𝑥
//  axis, and so on. Formally, if we number steps from one in the order they are done, then odd-numbered steps must be along the 𝑥
//  axis and even-numbered steps must be along the 𝑦
//  axis.

// Additionally, each step must have a length strictly greater than the length of the previous one.

// Output the minimum number of steps needed to reach (𝑥,𝑦)
// , or −1
//  if it is impossible.

// Input
// Each test contains multiple test cases. The first line contains the number of test cases 𝑡
//  (1≤𝑡≤104
// ). The description of the test cases follows.

// The first and only line of each case contains two integers 𝑥
//  and 𝑦
//  (1≤𝑥,𝑦≤109
// ).

// Output
// For each test case, output the minimum number of steps to reach (𝑥,𝑦)
//  or −1
//  if it is impossible.




package codeforces.contest;
import java.util.*;

public class ShortestIncreasingPath {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt();

        int[][] xyInputs = new int[intputNumber][2];
        for(int i = 0; i < intputNumber; i++){
            xyInputs[i][0] = sc.nextInt();
            xyInputs[i][1] = sc.nextInt();
        }

        for(int i = 0; i < intputNumber; i++){
            System.out.println(findShortPath(xyInputs[i][0], xyInputs[i][1]));
        }

        sc.close();
    }


    static int findShortPath(int x, int y){
        if(x == y){
            return -1;
        }
        if(y > x){
            return 2;
        }
         
        if(y == 1){
            return -1;
        }

        // then try in 3 steps, as x > y
        // so if x = y+1, then it is not possible to reach the destination
        // EXPLANATION: let (5, 4) because we make the first x step to be 1
        // then y step to be 4, now the x should be greater than previous step
        // that is 4, but if do 5, we are ahead of dest and cant reach our dest
        // so not possible 
        // BUT: if x = y+2 or x = y + k, where k >= 2, 
        // one can reach the dest in 3 steps
        // s

        if(x >= y+2){
            return 3;
        }

        return -1;
    }
}
