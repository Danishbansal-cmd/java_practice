// D. Game on Array
// time limit per test2 seconds
// memory limit per test256 megabytes
// You are given an array 𝑎
//  of 𝑛
//  positive integers. Alice and Bob will play a game with this array. They will take alternating turns, with Alice going first.

// At each turn, the player must choose a value 𝑥>0
//  that appears in 𝑎
//  at least once. Then,

// the player earns 1
//  point for each value 𝑥
//  in the array,
// each value 𝑥
//  in the array is decreased by 1
//  and becomes 𝑥−1
// .
// Note that the player can choose 𝑥
//  only if it is present in 𝑎
//  at the moment, so each valid move earns a positive amount of points. For example, if the array is [3,8,5,8]
//  and Alice chooses 𝑥=8
// , the array will become [3,7,5,7]
//  and Alice will earn 2
//  points.
// The game ends when no 𝑥
//  can be chosen; that is, when all the elements in the array are zero.

// Given that both players want to maximize their points and play optimally, calculate the amount of points that each player will end up with.

// Input
// Each test contains multiple test cases. The first line contains the number of test cases 𝑡
//  (1≤𝑡≤103
// ). The description of the test cases follows.

// The first line of each test case contains an integer 𝑛
//  (1≤𝑛≤2⋅105
// ) — the size of the array.

// The second line contains 𝑛
//  integers 𝑎1,𝑎2,…,𝑎𝑛
//  (1≤𝑎𝑖≤109
// ) — the elements of the array.

// It is guaranteed that the sum of 𝑛
//  over all test cases does not exceed 2⋅105
// .

// Output
// For each test case, output two integers, the amount of points Alice and Bob will get if both play optimally.


package codeforces.contest;
import java.util.*;

public class GameOnArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt();

        for(int i = 0; i < intputNumber; i++){
            int inputArraySize = sc.nextInt();
            int[] inputArray = new int[inputArraySize];
            for(int j = 0; j < inputArraySize; j++){
                inputArray[j] = sc.nextInt();
            }

            System.out.println(maxAliceBobPoints(inputArray));

        }

        sc.close();
    }

    static String maxAliceBobPoints(int[] arrayInput){
        int n = arrayInput.length;
        long[] arr = new long[n];
        Map<Long, Long> freq = new HashMap<>();

        for (int num : arrayInput) {
            long x = num;
            freq.put(x, freq.getOrDefault(x, 0L) + 1L);
        }

        // Create list of pairs (frequency, value)
        List<long[]> groups = new ArrayList<>();
        for (Map.Entry<Long, Long> e : freq.entrySet()) {
            groups.add(new long[]{e.getValue(), e.getKey()});
        }

        // Sort descending: first by frequency, then by value
        groups.sort((a, b) -> {
            if (a[0] != b[0]) return Long.compare(b[0], a[0]);
            return Long.compare(b[1], a[1]);
        });

        long alice = 0L, bob = 0L;
        int turn = 0; // 0 = Alice, 1 = Bob

        for (long[] g : groups) {
            long c = g[0]; // frequency
            long L = g[1]; // value

            long alice_moves = (L + (turn == 0 ? 1 : 0)) / 2;
            long bob_moves   = L - alice_moves;

            alice += alice_moves * c;
            bob   += bob_moves * c;

            if ((L & 1) == 1) turn ^= 1; // toggle turn if value is odd
        }

        return alice + " " + bob;
    }

    // static String maxAliceBobPoints(int[] arr){
    //     Map<Integer, Integer> mp = new HashMap<>();
    //     mp.put(0, 0);

    //     int totalPoints = 0;
    //     for(int num : arr){
    //         totalPoints += num;
    //     }
    //     System.out.println("totalPoints: " + totalPoints);

    //     for(int num : arr){
    //         mp.put(num, mp.getOrDefault(num, 0) + 1);
    //     }

    //     int maxOccuredNum = 0;
    //     int maxKey = -1;
    //     int[] maxOccuredNumAndMaxKey = maxOccuredNumAndMaxKey(mp);
    //     maxOccuredNum = maxOccuredNumAndMaxKey[0];
    //     maxKey = maxOccuredNumAndMaxKey[1];
    //     // System.out.println("maxOccuredNum: " + maxOccuredNum);
    //     //     System.out.println("maxKey: " + maxKey);
        

    //     int alicePoints = 0;
    //     int bobPoints = 0;

    //     System.out.println("mp.get(0): " + mp.get(0));

    //     int k = 10;

    //     while(mp.get(0) != totalPoints && k > 0){
    //         System.out.println("maxOccuredNum first");
    //         System.out.println("maxOccuredNum: " + maxOccuredNum);
    //         System.out.println("maxKey: " + maxKey);
    //         alicePoints += maxOccuredNum;
    //         mp.remove(maxKey);
    //         System.out.println("alicePoints: " + alicePoints);

    //         // new key will be reduced by 1, it the new key will
    //         // have the same occurence as the maxKey, and add to the
    //         // new reduceKey accordingly
    //         int newReduceKey = maxKey - 1;
    //         System.out.println("newReduceKey: " + newReduceKey);

    //         // if newReduceKey = 0 then find another maxOccuredNum and maxKey
    //         if(newReduceKey == 0){
    //             mp.put(newReduceKey, mp.getOrDefault(newReduceKey, 0) + maxOccuredNum);
    //             maxOccuredNumAndMaxKey = maxOccuredNumAndMaxKey(mp);
    //             maxOccuredNum = maxOccuredNumAndMaxKey[0];
    //             maxKey = maxOccuredNumAndMaxKey[1];
    //         }else{
    //             mp.put(newReduceKey, mp.getOrDefault(newReduceKey, 0) + maxOccuredNum);
    //             // the maxOccuredNum will be the occurences of the newReduceKey
    //             maxOccuredNum = mp.get(newReduceKey);
    //             maxKey = newReduceKey;
    //         }

    //         System.out.println("maxOccuredNum: " + maxOccuredNum);
    //         System.out.println("maxKey: " + maxKey);
    //         bobPoints += maxOccuredNum;
    //         mp.remove(maxKey);
    //         System.out.println("bobPoints: " + bobPoints);

    //         // new key will be reduced by 1, it the new key will
    //         // have the same occurence as the maxKey, and add to the
    //         // new reduceKey accordingly
    //         newReduceKey = maxKey - 1;
    //         System.out.println("newReduceKey: " + newReduceKey);

    //         // if newReduceKey = 0 then find another maxOccuredNum and maxKey
    //         if(newReduceKey == 0){
    //             mp.put(newReduceKey, mp.getOrDefault(newReduceKey, 0) + maxOccuredNum);
    //             maxOccuredNumAndMaxKey = maxOccuredNumAndMaxKey(mp);
    //             maxOccuredNum = maxOccuredNumAndMaxKey[0];
    //             maxKey = maxOccuredNumAndMaxKey[1];
    //         }else{
    //             mp.put(newReduceKey, mp.getOrDefault(newReduceKey, 0) + maxOccuredNum);
    //             // the maxOccuredNum will be the occurences of the newReduceKey
    //             maxOccuredNum = mp.get(newReduceKey);
    //             maxKey = newReduceKey;
    //         }

    //         k--;
    //     }


        
    //     return "" + alicePoints + " " + bobPoints;
    // }

    // static int[] maxOccuredNumAndMaxKey(Map<Integer, Integer> mp){
    //     int maxOccuredNum = Integer.MIN_VALUE;
    //     int maxKey = -1;

    //     for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
    //         int key = entry.getKey();
    //         int value = entry.getValue();

    //         if(value > maxOccuredNum && key != 0){
    //             maxOccuredNum = value;
    //             maxKey = key;
    //         }
    //     }

    //     return new int[]{maxOccuredNum == Integer.MIN_VALUE ? 0 : maxOccuredNum, maxKey == -1 ? 0 : maxKey};
    // }

}
