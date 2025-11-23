// B. Strange Machine
// time limit per test1.5 seconds
// memory limit per test256 megabytes

// You are given 𝑛
//  machines arranged in a circle, where 𝑛
//  is at most 20
// . Each machine is either of type A or type B. The machines are numbered clockwise from 1
//  to 𝑛
// , and the type of the 𝑖
// -th machine is denoted by 𝑠𝑖
// . Each machine takes an integer 𝑥
//  and updates it according to its type:

// Type A: Decrease 𝑥
//  by 1
// . Formally, update 𝑥:=𝑥−1
// .
// Type B: Replace 𝑥
//  with the floor of half its value. Formally, update 𝑥:=⌊𝑥2⌋
// , where ⌊𝑦⌋
//  denotes the floor of 𝑦
// , which is the greatest integer less than or equal to 𝑦
// .
// You are given 𝑞
//  queries, each consisting of a single integer 𝑎
// . In each query, you start at machine 1
//  holding an integer 𝑎
// . Each second, the following two actions occur in order:

// The current machine updates 𝑎
//  according to its type.
// Then, move one step clockwise to the next machine. Formally
// If you are at machine 𝑖
//  where 1≤𝑖≤𝑛−1
// , move to machine 𝑖+1
// .
// If you are at machine 𝑛
// , move to machine 1
// .
// This process continues until your integer 𝑎
//  becomes 0
// . For each query, determine the number of seconds required for 𝑎
//  to reach 0
// .

// Note that all queries are independent of each other.

// Input
// Each test contains multiple test cases. The first line contains the number of test cases 𝑡
//  (1≤𝑡≤104
// ). The description of the test cases follows.

// The first line of each test case contains two integers 𝑛
//  and 𝑞
//  (1≤𝑛≤20
// , 1≤𝑞≤104
// ) — the number of machines, and the number of queries, respectively.

// The second line of each test case contains a string 𝑠
//  (|𝑠|=𝑛
//  and 𝑠𝑖=𝙰 or 𝙱
// ) — the types of the machines.

// The third line of each test case contains 𝑞
//  integers 𝑎1,𝑎2,…,𝑎𝑞
//  (1≤𝑎𝑖≤109
// ) — the initial integer of each query.

// Note that there are no constraints on the sum of 𝑛
//  over all test cases.

// It is guaranteed that the sum of 𝑞
//  over all test cases does not exceed 104
// .

// Output
// For each test case, output 𝑞
//  integers representing the answers to each query.

// Example
// InputCopy
// 3
// 2 2
// BA
// 3 4
// 1 1
// B
// 20
// 6 4
// BAABBA
// 2 8 32 95
// OutputCopy
// 2
// 3
// 5
// 2
// 5
// 8
// 11
// Note
// In the first test case, the queries are as follows:

// Query 1
// : 𝑎=3
// Start at machine 1
// . Machine 1
//  replaces 𝑎
//  with the floor of half its value. Now, 𝑎=⌊32⌋=1
// .
// Move to machine 2
// . Machine 2
//  decreases 𝑎
//  by 1
// . Now, 𝑎=1−1=0
// .
// Therefore, it takes 2
//  seconds for 𝑎
//  to reach 0
// .
// Query 2
// : 𝑎=4
// Start at machine 1
// . Machine 1
//  replaces 𝑎
//  with the floor of half its value. Now, 𝑎=⌊42⌋=2
// .
// Move to machine 2
// . Machine 2
//  decreases 𝑎
//  by 1
// . Now, 𝑎=2−1=1
// .
// Move back to machine 1
// . Machine 1
//  replaces 𝑎
//  with the floor of half its value. Now, 𝑎=⌊12⌋=0
// .
// Therefore, it takes 3
//  seconds for 𝑎
//  to reach 0
// .
// In the second test case, there is only one query with 𝑎=20
// :

// Start at machine 1
// . Machine 1
//  replaces 𝑎
//  with the floor of half its value. Now, 𝑎=⌊202⌋=10
// .
// Move to machine 1
// . Machine 1
//  replaces 𝑎
//  with the floor of half its value. Now, 𝑎=⌊102⌋=5
// .
// Move to machine 1
// . Machine 1
//  replaces 𝑎
//  with the floor of half its value. Now, 𝑎=⌊52⌋=2
// .
// Move to machine 1
// . Machine 1
//  replaces 𝑎
//  with the floor of half its value. Now, 𝑎=⌊22⌋=1
// .
// Move to machine 1
// . Machine 1
//  replaces 𝑎
//  with the floor of half its value. Now, 𝑎=⌊12⌋=0
// .
// Therefore, it takes 5
//  seconds for 𝑎
//  to reach 0
// .

package codeforces.contest;

import java.util.Scanner;


// Read this article to understand more or ask gpt to explain the contents of the blog
// https://codeforces.com/blog/entry/147761
public class StrangeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt();

        for(int i = 0; i < intputNumber; i++){
            int numberOfMachines = sc.nextInt();
            int numberOfQueries = sc.nextInt();
            String typeOfMachine = sc.next();
            char[] machineTypes = typeOfMachine.toCharArray();
            int[] queryValues = new int[numberOfQueries];
            for(int j = 0; j < numberOfQueries; j++){
                queryValues[j] = sc.nextInt();
            }

            secondsToReachZeroByStrangeMachines(numberOfMachines, numberOfQueries, machineTypes, queryValues);
        }

        sc.close();
    }

    static void secondsToReachZeroByStrangeMachines(int numberOfMachines, int numberOfQueries, char[] machineTypes, int[] queryValues){
        int nB = 0; // number of 'B's in machinetype

        for(int i = 0; i < numberOfMachines; i++){
            if (machineTypes[i] == 'B') {
                nB++;
                break;
            }
        }

        for(int i = 0; i < numberOfQueries; i++){
            if(nB == 0){
                System.out.println(queryValues[i]);
            }else{
                int query = queryValues[i];
                int time = 0;
                while(query > 0){
                    for(int j = 0; j < numberOfMachines; j++){
                        if(query == 0) break;
                        time++;
                        if(machineTypes[j] == 'A') {
                            query -= 1;
                        }else{
                            query /= 2;
                        }
                    }
                }
                System.out.println(time);
            }
        }
    }
}
