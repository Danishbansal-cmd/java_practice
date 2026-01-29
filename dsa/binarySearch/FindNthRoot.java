package binarySearch;

public class FindNthRoot{
    public static void main(String[] args) {
        // Define the desired root (e.g., 3 for cube root)
        int nthroot = 3;
        // The number for which to find the root. Using 'long' for large numbers.
        long num = 34534574756L;

        // Call the function to compute the nth root and print the result
        System.out.println(findNthRoot(nthroot, num));
    }

    /**
     * Calculates the nth root of a given number using a binary search approach.
     * This method assumes the input number is positive and the root is positive.
     *
     * @param nthroot The integer root to find (e.g., 2 for square root, 3 for cube root).
     * @param num The number whose root is being calculated.
     * @return The calculated nth root as a double.
     */
    static double findNthRoot(int nthroot, long num){
        // 'nr' stores the best approximation found so far (initialized to 1)
        double nr = 1;
        // Cast the long num to a double for floating-point calculations
        double number = num;

        // Epsilon defines the precision threshold for the result.
        // The loop continues as long as the search range is larger than this value.
        double epsilon = 0.0000001;

        // Initialize the binary search range
        // The lower bound (left) is 1, as the root of any positive number >= 1 must be >= 1.
        double left = 1;
        // The upper bound (right) can be the number itself (if the number is > 1)
        double right = number;

        // The core binary search loop
        while((right - left) > epsilon){
            // Calculate the midpoint of the current range
            double mid = left + (right - left) / 2;

            // Check if the nth power of the midpoint is less than or equal to the original number
            if(square(mid, nthroot) <= number){
                // If true, 'mid' is a potential answer, so store it.
                // The actual answer must be in the range [mid, right], so update 'left'.
                nr = mid;
                left = mid;
            }else{
                // If false, the 'mid' is too large.
                // The actual answer must be in the range [left, mid], so update 'right'.
                right = mid;
            }
        }

        // 'nr' holds the final approximation within the desired precision 'epsilon'
        return nr;
    }

    /**
     * Calculates base raised to the power of exponent efficiently using exponentiation by squaring.
     *
     * @param base The base number (double).
     * @param exponent The exponent (integer, assumed to be positive for this context).
     * @return The result of base^exponent.
     */
    static double square(double base, int exponent){
        double ans = 1;

        // Loop using binary exponentiation logic
        while(exponent > 0){
            // If the exponent is odd, multiply the current answer by the base
            if(exponent % 2 == 1){
                ans = ans * base;
            }
            // Square the base for the next iteration (processing the next bit of the exponent)
            base = base * base;
            // Halve the exponent (integer division, effectively right-shifting)
            exponent /= 2;
            
        }

        return ans;
    }
}
