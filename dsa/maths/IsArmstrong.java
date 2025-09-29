package maths;

import java.util.Scanner;

public class IsArmstrong {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int testInputNumber = sc.nextInt();

        // int[] testCases = new int[testInputNumber];
        // for(int i = 0; i < testInputNumber; i++){
        //     testCases[i] = sc.nextInt();
        // }
        // sc.close();

        // for(int i = 0; i < testInputNumber; i++){
        //     System.out.println(isArmstrong(testCases[i]));
        // }

        int[] hardCordedTestCases = new int[]{153, 12};
        for(int i = 0; i < hardCordedTestCases.length; i++){
            System.out.println(isArmstrong(hardCordedTestCases[i]));
        }
    }

    public static boolean isArmstrong(int n) {
        int storeN = n;
        int sum = 0;

        while(n > 0){
            int digit = n%10;
            sum = sum + (int) (Math.pow(digit, 3));
            n /= 10;
        }

        if(sum == storeN){
            return true;
        }

        return false;
    }
}
