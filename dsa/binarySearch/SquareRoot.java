package binarySearch;

public class SquareRoot {

    /**
     * Main method to test the custom squareRoot function against the built-in Math.sqrt.
     */
    public static void main(String[] args) {
        int num = 34352;

        // Print the result from our custom binary search implementation
        System.out.println("Custom square root function result: " + squareRoot(num));
        
        // Print the result from Java's highly optimized built-in method for comparison
        System.out.println("Math.sqrt result: " + Math.sqrt(num));
    }

    /**
     * Calculates the square root of an integer using a binary search algorithm 
     * with floating-point precision.
     *
     * @param num The non-negative integer for which to find the square root.
     * @return The approximate square root as a double.
     */
    static double squareRoot(int num){
        // --- Input Validation ---
        // Handle the edge case where the input is negative. 
        // The square root of a negative real number is imaginary, so we return NaN (Not a Number).
        if (num < 0) return Double.NaN; 

        // --- Initialization ---
        double sr = 0; // This variable will store the best approximation found so far (the "floor")
        double left = 0; // The lower bound of our search range
        // The upper bound is initially the number itself (since the root of N < N for N>1)
        double right = num; 
        double mid;
        // Epsilon defines our desired precision. The loop stops when the search range is smaller than this value.
        double epsilon = 0.000001;  

        // --- Binary Search Loop ---
        // The loop continues as long as the search interval [left, right] is wider than our precision threshold.
        while(right - left > epsilon){
            // Calculate the midpoint using a method that prevents potential overflow (though less a concern with doubles here)
            mid = left + (right - left) / 2;

            // Check if the square of the midpoint is less than or equal to the target number
            if(mid * mid <= num){
                // If true, 'mid' is a potential candidate for the root (it's the current floor).
                // We store it, and move the left bound up to 'mid' to search for a more precise, larger value.
                sr = mid;
                left = mid;
            }else{
                // If false, 'mid*mid' is too large. The root must be smaller than 'mid'.
                // We move the right bound down to 'mid' to search the lower half.
                right = mid;
            }
        }

        // --- Return Result ---
        // After the loop terminates, 'sr' holds the best value found that is 
        // within 'epsilon' precision of the actual square root.
        return sr;
    }
}
