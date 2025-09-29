// C. Rabbits
// time limit per test2 seconds
// memory limit per test256 megabytes

// You have 𝑛
//  flower pots arranged in a line numbered from 1
//  to 𝑛
//  left to right. Some of the pots contain flowers, while others are empty. You are given a binary string 𝑠
//  describing which pots contain flowers (𝑠𝑖=1
// ) and which are empty (𝑠𝑖=0
// ). You also have some rabbits, and you want to take a nice picture of rabbits and flowers. You want to put rabbits in every empty pot (𝑠𝑖=0
// ), and for each rabbit, you can put it looking either to the left or to the right. Unfortunately, the rabbits are quite naughty, and they will try to jump, which will ruin the picture.

// Each rabbit will prepare to jump into the next pot in the direction they are looking, but they won't jump if there is a rabbit in that pot already or if there is another rabbit that prepares to jump into the same pot from the opposite side. Rabbits won't jump out of the borders (a rabbit at pot 1
//  looking to the left won't jump, same for a rabbit looking to the right at pot 𝑛
// ).

// Your goal is to choose the directions of the rabbits so that they never jump, allowing you to take your time to take the picture. You need to determine if there is a valid arrangement of rabbits such that no rabbit ever jumps.

// Input
// Each test contains multiple test cases. The first line contains the number of test cases 𝑡
//  (1≤𝑡≤104
// ). The description of the test cases follows.

// The first line of each test case contains an integer 𝑛
//  (1≤𝑛≤2⋅105
// ).

// The second line contains a binary string 𝑠
//  of size 𝑛
// , denoting the occupied and empty pots.

// It is guaranteed that the sum of 𝑛
//  over all test cases does not exceed 2⋅105
// .

// Output
// For each test case, print "YES" if there exists a configuration of rabbits that satisfies the condition, and "NO" otherwise.

// You can output the answer in any case (upper or lower). For example, the strings "yEs", "yes", "Yes", and "YES" will be recognized as



package codeforces.contest;
import java.util.Scanner;

public class Rabbits {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt();

        for(int i = 0; i < intputNumber; i++){
            int sizeOfString = sc.nextInt();
            String inputString = sc.next();

            if(inputString.length() > sizeOfString){
                return;
            }else{
                System.out.println(canRabbitsSitWithoutJumping(sizeOfString, inputString));
            }
        }

        sc.close();
    }

    static String canRabbitsSitWithoutJumping(int size, String s){
        
        return "";
    }
}


