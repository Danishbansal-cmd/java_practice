package recursion;

public class Basic {
    public static void main(String[] args) {
        // printNameThisTimes(0, 8, "Danish");
        // printNums(1, 8);
        // printNumsReverse(8, 8);


        // using Backtracking
        printNumsBacktracking(8, 8);
        printNumsReverseBacktracking(1, 8);


        // Recursion Types
        // sumOfNumsParameterized(4, 0);
        System.out.println(sumOfNumsFunctionalReturn(400));

        // factorial method
        System.out.println(fact(4));
    }

    public static void printNameThisTimes(int i, int n, String s){
        if(i > n){
            return;
        }
        System.out.println(s);
        printNameThisTimes(i+1, n, s);
    }

    public static void printNums(int i, int n){
        if(i > n){
            return;
        }
        System.out.println(i);
        printNums(i+1, n);
    }

    public static void printNumsReverse(int i, int n){
        if(i < 1){
            return;
        }
        System.out.println(i);
        printNumsReverse(i-1, n);
    }

    public static void printNumsBacktracking(int i, int n){
        if(i < 1){
            return;
        }
        printNumsBacktracking(i-1, n);
        System.out.println(i);
    }

    public static void printNumsReverseBacktracking(int i, int n){
        if(i > n){
            return;
        }
        printNumsReverseBacktracking(i+1, n);
        System.out.println(i);
    }

    public static void sumOfNumsParameterized(int i, int sum){
        if(i < 1){
            System.out.println(sum);
            return;
        }
        sumOfNumsParameterized(i-1, sum + i);
    }

    public static int sumOfNumsFunctionalReturn(int i){
        if(i == 0){
            return 0;
        }
        return i + sumOfNumsFunctionalReturn(i-1);
    }

    public static int fact(int i){
        if(i == 1){
            return 1;
        }
        return i * fact(i-1);
    }
}
