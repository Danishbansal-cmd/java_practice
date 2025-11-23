package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceWithTarget{
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 2, 4, 0};
        int target = 5;

        // all the possible subsequences
        // allSubsequencesWithTarget(0, new ArrayList<>(), arr, 0, target);

        // one subsequences only
        // oneSubsequencesWithTarget(0, new ArrayList<>(), arr, 0, target);

        // count the subsequences With Target
        System.out.println(countSubsequencesWithTarget(0, arr, 0, 4));
    }

    // Time Complexity: O(2^n), where n is length of arr
    public static void allSubsequencesWithTarget(int index, List<Integer> list, int[] arr, int sum, int target){
        if(index >= arr.length){
            if(sum == target){
                System.out.println(list);
            }
            return;
        }
        // take or pick the particular index
        list.add(arr[index]);
        // add the element into sum
        sum += arr[index];
        allSubsequencesWithTarget(index+1, list, arr, sum, target);

        // not pick, or not take condition, this element is not added to your subsequence
        list.remove(list.size() - 1);
        // remove the element from the sum
        sum -= arr[index];
        allSubsequencesWithTarget(index+1, list, arr, sum, target);
    }

    // Time Complexity: O(2^n), where n is length of arr
    public static boolean oneSubsequencesWithTarget(int index, List<Integer> list, int[] arr, int sum, int target){
        if(index >= arr.length){
            if(sum == target){
                System.out.println(list);
                return true;
            }
            return false;
        }
        // take or pick the particular index
        list.add(arr[index]);
        // add the element into sum
        sum += arr[index];
        if(oneSubsequencesWithTarget(index+1, list, arr, sum, target) == true){
            return true;
        };

        // not pick, or not take condition, this element is not added to your subsequence
        list.remove(list.size() - 1);
        // remove the element from the sum
        sum -= arr[index];
        if(oneSubsequencesWithTarget(index+1, list, arr, sum, target) == true){
            return true;
        }

        // default case
        return false;
    }

    public static int countSubsequencesWithTarget(int index, int[] arr, int sum, int target){
        // if the arr contains strictly positive number
        if(sum > target){
            return 0;
        }

        if(index >= arr.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }

        // adding the element into the arr Sum
        sum += arr[index];
        int l = countSubsequencesWithTarget(index + 1, arr, sum, target);
        
        // not adding the element into the arr Sum
        sum -= arr[index];
        int r = countSubsequencesWithTarget(index + 1, arr, sum, target);

        // returning the total count
        return l + r;
    }
}
