package arrays;

public class FindElementInRotatedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,8,1,2,3};

        System.out.println(findElementInRotatedArray(arr, 4));
    }

    static int findElementInRotatedArray(int[] arr, int target){
        int n = arr.length;

        int left = 0, right = n-1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] == target){
                return mid;
            }

            // if left part of the array is sorted
            if(arr[left] <= arr[mid]){
                if(arr[left] <= target && target <= arr[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{ // right part of the array is sorted
                if(arr[mid] <= target && target <= arr[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
