// B. New Year Cake
// time limit per test2 seconds
// memory limit per test512 megabytes
// Monocarp is going to bake a New Year cake.

// The cake must consist of at least one layer. The size of the top layer of the cake must be 1
// ; the size of the layer below it must be 2
// ; the layer below that must be 4
// , and so on (each layer, except for the top one, is twice the size of the layer above it).

// Additionally, each layer must be covered with either white or dark chocolate. To cover a layer of size 𝑘
// , Monocarp will need 𝑘
//  kilograms of chocolate. Each layer must be covered with exactly one type of chocolate, and these types must alternate (if some layer is covered with dark chocolate, both the layer directly below it and the layer directly above it must be covered with white chocolate, and vice versa).

// Monocarp has 𝑎
//  kilograms of white chocolate and 𝑏
//  kilograms of dark chocolate. He wants to calculate the maximum number of layers that the cake can consist of, ensuring that he has enough chocolate of both types.

// Input
// The first line contains one integer 𝑡
//  (1≤𝑡≤104
// ) — the number of test cases.

// Each test case consists of one line containing two integers 𝑎
//  and 𝑏
//  (1≤𝑎,𝑏≤106
// ).

// Output
// For each test case, output one integer — the maximum possible number of layers in the cake.

// Example
// InputCopy
// 7
// 1 1
// 1 2
// 3 1
// 4 3
// 5 2
// 1000000 1000000
// 1000000 1
// OutputCopy
// 1
// 2
// 2
// 2
// 3
// 20
// 2
// Note
// In the first example, Monocarp can bake a cake with one layer of size 1
//  and cover it with any type of chocolate.

// In the second example, Monocarp can bake a cake with two layers: the top layer of size 1
//  with white chocolate, and below it a layer of size 2
//  with dark chocolate.

// In the third example, Monocarp can bake a cake with two layers: the top layer of size 1
//  with dark chocolate, and below it a layer of size 2
//  with white chocolate.

// In the fourth example, Monocarp can bake a cake with two layers: the top layer of size 1
//  with dark chocolate, and below it a layer of size 2
//  with white chocolate. Note that a cake with three layers, where the top layer of size 1
//  and the layer below it of size 2
//  are both dark chocolate, and the bottom layer of size 4
//  is white chocolate, is not valid, as the types of layers must alternate.





 package codeforces.contest;

import java.util.Scanner;

public class NewYearCake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt(); // Number of test cases

        // Process each test case one by one
        while (intputNumber-- > 0) {
            int whiteChocolate = sc.nextInt();
            int darkChocolate = sc.nextInt();
            
            System.out.println(getMaxLayersNewYearCake(whiteChocolate, darkChocolate));
        }
        sc.close(); // Close the Scanner to free resources
    }

    static int getMaxLayersNewYearCake(long a, long b) {
        int maxL = 0;
        // The maximum layers will not exceed ~40 given the 10^6 limit
        long sumEven = 0; // Layers 1, 3, 5... 
        long sumOdd = 0;  // Layers 2, 4, 6... 

        for (int i = 1; i <= 40; i++) {
            // Initial Value: The number 1 in binary is represented as ...0001.
            // Shifting: Shifting this 1 to the left by i positions effectively adds i zeros at the end of its binary representation.
            long size = 1L << (i-1); // 2^i (the first layer is 2^0 that is 1 not 2^1 = 2, so offsetting the index by minus 1)
            if (i % 2 == 0) sumEven += size;
            else sumOdd += size;

            // Check both alternating patterns:
            // 1. Even layers use 'a', Odd layers use 'b'
            // 2. Even layers use 'b', Odd layers use 'a'
            if ((sumEven <= a && sumOdd <= b) || (sumEven <= b && sumOdd <= a)) {
                maxL = i;
            } else {
                break; // Cannot form L layers, so maxL is the previous L
            }
        }
        return maxL;
    }
}
