package classTest;

public class TwoSum {
    public static void main(String[] args){
        int[] arr = new int[]{1, 1, 3, 5, 8, 9, 10};
        int target = 12;
        System.out.println(findTwoSum(arr, target));
    }

    public static String findTwoSum(int[] arr, int target){
        int n = arr.length;
        int left = 0, right = n - 1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                return arr[left] + " " + arr[right];
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }

        return arr[left] + " " + arr[right];
    }
}
