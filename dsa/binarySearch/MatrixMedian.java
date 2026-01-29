// Matrix Median
// Subscribe to TUF+

// Hints
// Company
// Given a 2D array matrix that is row-wise sorted. The task is to find the median of the given matrix.

// Example 1
// Input: matrix=[ [1, 4, 9], [2, 5, 6], [3, 7, 8] ] 
// Output: 5
// Explanation: If we find the linear sorted array, the array becomes 1 2 3 4 5 6 7 8 9. So, median = 5
// Example 2
// Input: matrix=[ [1, 3, 8], [2, 3, 4], [1, 2, 5] ] 
// Output: 3
// Explanation: If we find the linear sorted array, the array becomes 1 1 2 2 3 3 4 5 8. So, median = 3


package binarySearch;

/**
 * Problem: Find the median of a matrix where each row is sorted individually.
 * The median is the middle element in a sorted list of all matrix elements combined.
 * For an odd number of elements (N), the median is at index (N/2) in the sorted array.
 */
public class MatrixMedian {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 4, 9}, {2, 5, 6}, {3, 7, 8}};

        // sorted mat2 will be: 1, 2, 3, 4, 5, 5, 7, 9, 10, 10, 10, 11, 12, 14, 16
        // Total elements = 15. Median index = 15 / 2 = 7 (0-indexed). 8th element is 9.
        int[][] mat2 = new int[][]{{1, 5, 7, 10, 11}, {2, 3, 4, 5, 10}, {9, 10, 12, 14, 16}};

        System.out.println("mat2 MatrixMedian: " + matrixMedian(mat2));
    }

    /**
     * Finds the median using Binary Search on the range of possible values [min, max].
     * Time Complexity: O(log(max-min) * rows * log(cols))
     */
    static int matrixMedian(int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;

        // The median is the value that has more than (total elements / 2) numbers 
        // less than or equal to it in a sorted sequence.
        int required = (rows * cols) / 2;

        // Establish the search space range [minVal, maxVal]
        // Since rows are sorted, the minimum is in the first column and maximum in the last column.
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0; i < rows; i++){
            minVal = Math.min(mat[i][0], minVal);
            maxVal = Math.max(mat[i][cols - 1], maxVal);
        }

        int left = minVal;
        int right = maxVal;

        // Binary Search on value range
        while(left <= right){
            int mid = left + (right - left) / 2;

            // Count how many elements in the matrix are <= mid
            int smallerEquals = blackBox(mat, rows, cols, mid);

            // If the count of elements <= mid is less than or equal to 'required',
            // it means the median must be a larger value.
            if(smallerEquals <= required){
                left = mid + 1;
            }else{
                // Otherwise, the current mid could be the median, or the median is smaller.
                right = mid - 1;
            }
        }

        // 'left' will eventually converge to the smallest number that satisfies 
        // the condition of having > required elements less than or equal to it.
        return left;
    }

    /**
     * Helper function (Upper Bound) to count elements in the matrix <= 'num'.
     * Uses binary search on each row to efficiently count elements.
     */
    static int blackBox(int[][] mat, int rows, int cols, int num){
        int smallerEquals = 0;

        for(int i = 0; i < rows; i++){
            // Standard Binary Search to find the first element > num in the current row
            int left = 0;
            int right = cols - 1;
            int ans = cols; // Default if no element is greater than num
            
            while(left <= right){
                int mid = left + (right - left) / 2;

                if(mat[i][mid] > num){
                    // If current element is > num, it might be the upper bound
                    ans = mid;
                    right = mid - 1;
                }else{
                    // If current element is <= num, search in the right half
                    left = mid + 1;
                }
            }

            // 'ans' represents the index of the first element > num.
            // This index is equal to the count of elements <= num in this row.
            smallerEquals += ans;
        }

        return smallerEquals;
    }
}
