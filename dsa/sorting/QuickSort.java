package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,34 ,34, 46, 56, 56, 567, 54, 656, 56};

        System.out.println(Arrays.toString(QuickSortMethod(arr, 0, arr.length - 1)));
    }

    public static int[] QuickSortMethod(int[] arr, int left, int right){
        if(left < right){
            int pi = partition(arr, left, right);

            QuickSortMethod(arr, left, pi - 1);
            QuickSortMethod(arr, pi + 1, right);
        }
        return arr;
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = arr[right]; // choosing the righmost element to be the pivot
        int i = left; // ith to be the leftmost element

        for(int j = left; j < right; j++){
            if(arr[j] <= pivot){
                // swap arr[i] & arr[j]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

                // increment after swapping
                // now the i has the new location where the new element could be swapped
                i++;
            }
        }

        // swapping the current ith element and the arr[right] (pivot) element
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;

        return i; // this is the pivot index
    }
}
