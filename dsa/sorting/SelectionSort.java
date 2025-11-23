package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{345, 6, 68, 89, 1, 34 ,34, 46, 56, 56, 567, 54, 656, 56};

        System.out.println(Arrays.toString(SelectionSortMethod(arr, 0, arr.length - 1)));
    }

    public static int[] SelectionSortMethod(int[] arr, int left, int right){
        for(int i = 0; i <= right; i++){
            int min = i;

            for(int j = i + 1; j <= right; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }

            if(min != i){
                // swap arr[i](current element index) with arr[min](min element index)
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }
}
