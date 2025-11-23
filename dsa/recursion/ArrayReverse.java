package recursion;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 6, 45, 43, 67};

        // calling the function to reverse the array
        reverseArray(0, arr, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArray(int left, int[] arr, int right){
        if(left > right){
            return;
        }
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverseArray(left + 1, arr, right - 1);
    }
}
