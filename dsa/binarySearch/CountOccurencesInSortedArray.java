package binarySearch;

public class CountOccurencesInSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 3};
        int[] nums2 = new int[]{5, 5, 5, 5, 5, 5};
        int target = 4;
        int target2 = 5;

        System.out.println(countOccurencesInSortedArray(nums2, target2));
    }

    static int countOccurencesInSortedArray(int[] nums, int target){
        int n = nums.length;

        int start = n;
        int end = n;

        int left = 0;
        int right = n - 1;
        while(left <= right){
            int search = left + (right - left) / 2;

            if(nums[search] >= target){
                start = search;
                right = search - 1;
            }else{
                left = search + 1;
            }
        }

        if(start == n || nums[start] != target){
            return 0;
        }else{

            left = 0;
            right = n - 1;

            while(left <= right){
                int search = left + (right - left) / 2;

                if(nums[search] > target){
                    end = search;
                    right = search - 1;
                }else{
                    left = search + 1;
                }
            }
        }

        return end - start;
    }
}
