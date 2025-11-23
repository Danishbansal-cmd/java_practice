package arrays;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] nums1 = {10, 5, 2, 7, 1, 9, 4, 57, 997, 779, 996, 68, 568, 344, 23, 345, 765, 45, 34, 999};
        System.out.println("secondLargestElement: " + secondLargestElement(nums1));
        
        int[] nums2 = {10};
        System.out.println("secondLargestElement: " + secondLargestElement(nums2));
    }

    static int secondLargestElement(int[] nums){
        int largest = 0;
        int secondLargest = 0;

        for(int num : nums){
            if(num > largest){
                secondLargest = largest;
                largest = num;
            }
        }

        return secondLargest;
    }
}

