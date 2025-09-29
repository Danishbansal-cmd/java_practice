package maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PrintAllDivisors {
    public static void main(String[] args) {
        int[] hardCordedTestCases = new int[]{153, 12};
        for(int i = 0; i < hardCordedTestCases.length; i++){
            System.out.println(divisors(hardCordedTestCases[i]));
        }
    }

    // CAREFUL OBSERVATION
    // 1 * 36 = 36 
    // 2 * 18 = 36
    // 3 * 12 = 36
    // 4 * 9 = 36
    // 6 * 6 = 36
    // 9 * 4 = 36
    // 12 * 3 = 36
    // 18 * 2 = 36
    // 36 * 1 = 36

    // All the numbers after the 6 * 6 are just the repeat of the above but in reverse way
    // like this
    // 1 * 36 = 36 * 1
    // 2 * 18 = 18 * 2
    // 3 * 12 = 12 * 3
    // So we can run the loop till the Math.sqrt(num) and 
    // then find all the divisors of the number

    // time complexity O(sqrt(n))
    public static String divisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<>();
        // rather than using the Math.sqrt(n) here use this
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                divisors.add(i); // if i is the factor of n
                if(n/i != i){ // then n/i will also be the factor of n, let n=36, i = 6, so to check 36/6 != 6
                    divisors.add(n/i);
                }
            }
        }
        Collections.sort(divisors);

        int arrl = divisors.size();
        int[] divisorsArr = new int[arrl];
        for(int i = 0; i < arrl; i++){
            divisorsArr[i] = divisors.get(i);
        }
        return Arrays.toString(divisorsArr);
    }
}
