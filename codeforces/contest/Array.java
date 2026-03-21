package codeforces.contest;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt();

        for (int i = 0; i < intputNumber; i++) {
            int n = sc.nextInt();

            int[] numbers = new int[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = sc.nextInt();
            }

            int[] result = approachBruteForceArray(n, numbers);

            // Print in Codeforces format
            for(int k = 0; k < n; k++){
                System.out.print(result[k] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    static int[] approachBruteForceArray(int n, int[] numbers){
        int[] result = new int[n];
        
        for(int i = 0; i < n; i++){
            int min = 0;
            int max = 0;
            for(int j = i; j < n; j++){
                if(numbers[j] > numbers[i]){
                    max++;
                }else if(numbers[j] < numbers[i]){
                    min++;
                }

                result[i] = Math.max(min, max);
            }
        }
        return result;
    }
}
