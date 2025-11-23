package recursion;
import java.util.List;
import java.util.ArrayList;

// Subsequence is the contiguos elements following the order, when the some of 
// the elements could be skipped or removed

// Example - arr = [1, 2, 3]
// Subquences can be [], [1], [2], [3], [1,2], [1,3], [1,2,3], [2,3]

public class Subsequence {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2};

        createAllSubsequences(0, new ArrayList<>(), arr);
    }

    // Time Complexity: O(2^n), where n is length of arr
    public static void createAllSubsequences(int index, List<Integer> list, int[] arr){
        if(index >= arr.length){
            System.out.println(list);
            return ;
        }
        // take or pick the particular index
        list.add(arr[index]);
        createAllSubsequences(index+1, list, arr);
        // not pick, or not take condition, this element is not added to your subsequence
        list.remove(list.size() - 1);
        createAllSubsequences(index+1, list, arr);
    }
}
