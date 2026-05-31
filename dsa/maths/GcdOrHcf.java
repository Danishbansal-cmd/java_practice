package maths;

import java.util.Arrays;

public class GcdOrHcf {
    public static void main(String[] args) {
        int[][] hardCordedTestCases = new int[][]{new int[]{2400, 60}, new int[]{24, 60}, new int[]{34324, 234}};
        for(int i = 0; i < hardCordedTestCases.length; i++){
            System.out.println(Arrays.toString(hardCordedTestCases[i]) + ": " +  findGcdOrHcf(hardCordedTestCases[i][0], hardCordedTestCases[i][1]));
        }
    }

    // It is find using the EUCLIDEAN ALGORITHM
    // it uses the concept like this
    // gcd(a % b, b) where a > b
    // and keep solving it until one it becomes 0 then the other is the
    // Greatest Common Divisor or Highest Common Factor

    // time complexity is O(log(base phi)Math.min(a,b))
    public static int findGcdOrHcf(int a, int b){

        while(a > 0 && b > 0){
            if(a > b) a = a % b;
            else b = b % a;
        }
        if(a == 0) return b;
        return a;
    }

    public static int compute_gcd(int a, int b) {
        // Repeat the process until b becomes 0
        while (b != 0) {

            // Store b temporarily
            // If b > a, this effectively swaps a and b in the next step
            int temp = b;

            // If a > b, then we replace b with a % b
            // and a with b
            // This reduces the problem and moves us closer to the GCD
            b = a % b;

            // Now assign temp (old b) to a
            // This shifts the values for the next iteration
            a = temp;
        }

        // When b becomes 0, 'a' will contain the GCD
        return a;
    }

    static int findGCD(int a, int b){
        while(a > 0 && b > 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }

}
