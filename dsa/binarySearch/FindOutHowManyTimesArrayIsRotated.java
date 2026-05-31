package binarySearch;

public class FindOutHowManyTimesArrayIsRotated{
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 6, 7, 7, 8, 8, 9, 9, 0, 1, 2, 3};
        int[] nums2 = new int[]{0, 1, 2, 3, 4, 5, 6, 6, 7, 7, 8, 8, 9, 9,};

        System.out.println("findOutHowManyTimesArrayIsRotated: " + findOutHowManyTimesArrayIsRotated(nums));
        System.out.println("findOutHowManyTimesArrayIsRotatedByFindingMinElement: " + findOutHowManyTimesArrayIsRotatedByFindingMinElement(nums));
    }

    // approach1 finding the maxElement
    static int findOutHowManyTimesArrayIsRotated(int[] nums){
        int n = nums.length;

        int rotated = 0;

        int left = 0;
        int right = n-1;

        if(nums[left] <= nums[right]){
            return rotated;
        }

        int maxElement = Integer.MIN_VALUE;
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] >= maxElement){
                maxElement = nums[mid];
                // then minus the left 0 index from the maxElement index and then plus 1
                rotated = mid - 0 + 1;
            }

            // left sorted
            if(nums[left] <= nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println("left: " + left);
        System.out.println("right: " + right);
        System.out.println("maxElement: " + maxElement);

        return rotated;
    }

    // approach1 finding the maxElement
    static int findOutHowManyTimesArrayIsRotatedByFindingMinElement(int[] nums){
        int n = nums.length;

        int left = 0;
        int right = n-1;

        if(nums[left] <= nums[right]){
            return 0;
        }

        while(left <= right){
            int mid = left + (right - left) / 2;

            // left sorted
            if(nums[left] <= nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println("left2: " + left);
        System.out.println("right2: " + right);

        return left;
    }
}