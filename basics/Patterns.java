package basics;

import java.util.Scanner;

public class Patterns {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        int[] nums = new int[testCases];
        for(int i = 0; i < testCases; ++i){
            int n = sc.nextInt();
            nums[i] = n;
        }

        for(int i = 0; i < testCases; ++i){
            printPattern22(nums[i]);
        }

        sc.close();
    }

    static void printPattern1(int n){
        // pattern 1
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printPattern2(int n){
        // pattern 2
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < i+1; ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printPattern3(int n){
        // pattern 3
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void printPattern4(int n){
        // pattern 4
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void printPattern5(int n){
        // pattern 5
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= (n - i + 1); ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printPattern6(int n){
        // pattern 6
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= (n - i + 1); ++j){
                System.out.print(j +" ");
            }
            System.out.println();
        }
    }

    static void printPattern7(int n){
        // pattern 7
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= (n - i); ++j){
                System.out.print("  ");
            }
            for(int j = 1; j <= ((i-1) * 2 + 1); ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printPattern8(int n){
        // pattern 8
        
        // rows
        for(int i = 0; i < n; ++i){

            // space
            for(int j = 0; j < i; ++j){
                System.out.print("  ");
            }

            // star
            for(int j = 0; j < ((n - i) * 2 - 1); ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printPattern9(int n){
        // pattern 9

        printPattern7(n);
        printPattern8(n);
    }

    static void printPattern10(int n){
        // pattern 10

        // rows
        for(int i = 0; i < n*2-1; ++i){
            // star
            int star = i;
            if(i > n) star = 2*n - i;
            for(int j = 0; j < star; ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printPattern11(int n){
        // pattern 11

        // rows
        for(int i = 0; i < n; ++i){
            // star
            for(int j = 0; j <= i; j++){
                System.out.print((i+j+1)%2);
            }
            System.out.println();
        }
    }

    static void printPattern12(int n){
        // pattern 12

        // rows
        for(int i = 0; i < n; ++i){
            // numbers
            for(int j = 1; j <= i+1; j++){
                System.out.print(j);
            }

            // space
            for(int j = 0; j < (n-i-1)*2; j++){
                System.out.print(" ");
            }

            // numbers
            for(int j = i+1; j >= 1; j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void printPattern13(int n){
        // pattern 13

        int num = 1;
        // rows
        for(int i = 0; i < n; ++i){
            // numbers
            for(int j = 0; j <= i; j++){
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    static void printPattern14(int n){
        // pattern 14

        // rows
        for(int i = 0; i < n; ++i){
            char ch = 'A';
            for(int j = 0; j <= i; j++){
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }

    static void printPattern15(int n){
        // pattern 15

        // rows
        for(int i = 0; i < n; ++i){
            char ch = 'A';
            for(int j = 0; j < (n - i); j++){
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }

    static void printPattern16(int n){
        // pattern 16

        // rows
        char ch = 'A';
        for(int i = 0; i < n; ++i){
            for(int j = 0; j <= i; j++){
                System.out.print(ch + " ");
            }
            ch++;
            System.out.println();
        }
    }

    static void printPattern17(int n){
        // pattern 17

        // rows
        for(int i = 0; i < n; ++i){
            // space
            for(int j = 0; j < n-i-1; j++){
                System.out.print("  ");
            }

            char ch = 'A';
            // characters
            for(int j = 0; j < i*2+1; j++){
                System.out.print(ch + " ");
                if(j < i) {
                    ch++;
                }else{
                    ch--;
                }
            }

            // space
            for(int j = 0; j < n-i-1; j++){
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    static void printPattern18(int n){
        // pattern 18

        // rows
        for(int i = 0; i < n; ++i){
            char ch = (char) (65 + n - i - 1);
            // characters
            for(int j = 0; j <= i; j++){
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }

    static void printPattern19(int n){
        // pattern 19

        // rows
        for(int i = 0; i < n; ++i){
            // stars
            for(int j = 0; j < (n - i); j++){
                System.out.print("* ");
            }
            // space
            for(int j = 0; j < i*2; j++){
                System.out.print("  ");
            }
            // stars
            for(int j = 0; j < (n - i); j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        // rows
        for(int i = 0; i < n; ++i){
            // stars
            for(int j = 0; j <= i; j++){
                System.out.print("* ");
            }
            // space
            for(int j = 0; j < (n - i - 1)*2; j++){
                System.out.print("  ");
            }
            // stars
            for(int j = 0; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printPattern20(int n){
        // pattern 20

        // rows
        for(int i = 1; i <= 2*n - 1; ++i){

            int stars = i;
            if(stars > n) stars = 2*n - i;
            // stars
            for(int j = 1; j <= stars; j++){
                System.out.print("* ");
            }
            // space
            for(int j = 1; j <= (n - stars) * 2; j++){
                System.out.print("  ");
            }
            // stars
            for(int j = 1; j <= stars; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printPattern21(int n){
        // pattern 21

        // rows
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == n - 1){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void printPattern22(int n){
        // pattern 22

        // rows
        for(int i = 0; i < 2*n-1; ++i){
            for(int j = 0; j < 2*n-1; j++){
                int top = i;
                int left = j;
                int right = (2*n - 2) - j;
                int down = (2*n - 2) - 1;
                System.out.print(n - Math.min(Math.min(top, down), Math.min(left, right)) + " ");

            }
            System.out.println();
        }
    }
}
