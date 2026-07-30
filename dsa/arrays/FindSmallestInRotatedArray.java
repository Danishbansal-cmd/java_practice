package arrays;

public class FindSmallestInRotatedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{6,7,8,9,12,1,2,3,4,5};
        
        // it returns the smallest element
        System.out.println(findSmallestInRotatedArray(arr));
    }

    static int findSmallestInRotatedArray(int[] arr){
        int n = arr.length;

        int smallest = Integer.MAX_VALUE;

        int left = 0, right = n - 1;
        while(left <= right){

            // Current range is sorted
            if(arr[left] < arr[right]){
                smallest = Math.min(smallest, arr[left]);
                break;
            }

            int mid = left + (right - left) / 2;
            smallest = Math.min(smallest, arr[mid]);

            // if left part is sorted, then the element must be in the other 2nd right part
            if(arr[left] <= arr[mid]){
                left = mid + 1;
            }else{ // if the right part is sorted, then the smallest will be in 1st left part
                right = mid - 1;
            }
        }

        return smallest;
    }
}
