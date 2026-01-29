// Find row with maximum 1's
// Subscribe to TUF+

// Hints
// Company
// Given a non-empty grid mat consisting of only 0s and 1s, where all the rows are sorted in ascending order, find the index of the row with the maximum number of ones.

// If two rows have the same number of ones, consider the one with a smaller index. If no 1 exists in the matrix, return -1.


// Example 1

// Input : mat = [ [1, 1, 1], [0, 0, 1], [0, 0, 0] ]

// Output: 0

// Explanation: The row with the maximum number of ones is 0 (0 - indexed).

// Example 2

// Input: mat = [ [0, 0], [0, 0] ]

// Output: -1

// Explanation: The matrix does not contain any 1. So, -1 is the answer.

package binarySearch;

public class FindRowWithMaximum1s {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 1, 1}, {0, 0, 1}, {0, 0, 0}};
        int[][] mat2 = new int[][]{{0, 0, 1}, {0, 1, 1}, {1, 1, 1}};

        System.out.println("mat: " + findRowWithMaximum1s(mat));
        System.out.println("mat2: " + findRowWithMaximum1s(mat2));
    }

    /**
     * Approach: Row-wise Binary Search
     * 
     * Logic:
     * 1. Since each row in the matrix is sorted (0s followed by 1s), the 1s always 
     *    appear at the end of the row.
     * 2. For every row, we perform a binary search to find the "first occurrence" of 1.
     * 3. Once the index of the first 1 is found, the total count of 1s in that row 
     *    is calculated as: (Total Columns - First Index of 1).
     * 4. We maintain a global maximum to keep track of which row index has the 
     *    highest count of 1s encountered so far.
     * 
     * Time Complexity: O(N * log M), where N is number of rows and M is number of columns.
     * Space Complexity: O(1).
     */
    static int findRowWithMaximum1s(int[][] mat){
        // Variables to track the row index with the most 1s and the highest count found
        int rowWithMaximum1s = -1;
        int numberOf1sInResultRow = 0;

        int rows = mat.length;
        int cols = mat[0].length;

        // Traverse each row one by one
        for(int i = 0; i < rows; i++){
            // Initialize binary search boundaries for the current row
            int left = 0;
            int right = cols - 1;

            // Perform binary search to find the leftmost (first) 1 in the row
            while (left <= right) {
                int mid = left + (right - left) / 2;

                // If current element is 1, search the left half for an earlier 1
                if(mat[i][mid] >= 1){
                    right = mid - 1;
                }else{
                    // If current element is 0, the first 1 must be in the right half
                    left = mid + 1;
                }
            }

            // After binary search, 'right + 1' (which is 'left') is the index of the first 1.
            // Number of 1s = total elements - index of first 1.
            int numberOf1sInThisRow = (cols - 1) - right; 
            
            // If current row has more 1s than our previous maximum, update trackers
            if(numberOf1sInThisRow > numberOf1sInResultRow){
                numberOf1sInResultRow = numberOf1sInThisRow;
                rowWithMaximum1s = i;
            }
        }

        // Return the index of the row with the maximum number of 1s
        return rowWithMaximum1s;
    }
}
