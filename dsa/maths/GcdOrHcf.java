package maths;

import java.util.Arrays;

public class GcdOrHcf {
    public static void main(String[] args) {
        int[][] hardCordedTestCases = new int[][]{new int[]{1, 2}, new int[]{153, 12}};
        for(int i = 0; i < hardCordedTestCases.length; i++){
            System.out.println(Arrays.toString(hardCordedTestCases[i]) + ": " +  findGcdOrHcf(hardCordedTestCases[i]));
        }
    }

    // It is find using the EUCLIDEAN ALGORITHM
    // it uses the concept like this
    // gcd(a % b, b) where a > b
    // and keep solving it until one it becomes 0 then the other is the
    // Greatest Common Divisor or Highest Common Factor

    // time complexity is O(log(base phi)Math.min(a,b))
    public static int findGcdOrHcf(int[] num){
        int a = num[0];
        int b = num[1];

        while(a > 0 && b > 0){
            if(a > b) a = a % b;
            else b = b % a;
        }
        if(a == 0) return b;
        return a;
    }
}
