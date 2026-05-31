package hashing;

import java.util.Arrays;

public class MaxFrequencyAfterKOperation {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,67,8,0,5,3,2,45,78,54,224,57,8,99,74,3,22,23,5,6,89,0,7,654,3,22,3,4,657,8,7,65,4,32,2,45,7};
        int k = 67;

        System.out.println(maxFrequencyAfterKOperations(arr, k));
    }

    public static int maxFrequencyAfterKOperations(int[] arr, int k){
        Arrays.sort(arr);

        int left = 0;
        int total = 0;
        int res = 0;

        for(int right = 0; right < arr.length; right++){
            total += arr[right];

            while((right - left + 1) * arr[right] > total + k){
                total -= arr[left];
                left++;
            }

            res = Math.max(res, (right - left + 1));
        }
        return res;
    }
}
