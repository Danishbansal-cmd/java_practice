package recursion;

public class MultipleRecursionFibonacci {
    public static void main(String[] args){
        System.out.println(multipleRecursionForFibonacci(3));
    }

    // Time Complexity: O(2^n), where n is the nth number in fibonacci
    public static int multipleRecursionForFibonacci(int n){
        if(n <= 1){
            return n;
        }
        return multipleRecursionForFibonacci(n - 1) + multipleRecursionForFibonacci(n - 2);
    }
}
