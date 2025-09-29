package maths;

public class CheckForPrime {
    public static void main(String[] args) {
        int[] hardCordedTestCases = new int[]{153, 12, 11};
        for(int i = 0; i < hardCordedTestCases.length; i++){
            System.out.println(hardCordedTestCases[i] + ": " + isPrime(hardCordedTestCases[i]));
        }
    }

    // as we already know from the PrintAllDivisors program
    // that all the factors can be known from 1 to the the sqrt of number

    // time complexity O(sqrt(n))
    public static boolean isPrime(int n) {
        int countFactors = 0;

        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                countFactors++;
                if(n/i != i){
                    countFactors++;
                }
            }
        }

        if(countFactors > 2){
            return false;
        }

        return true;
    }
}

