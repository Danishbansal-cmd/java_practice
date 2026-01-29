package dynamicProgramming;

/**
 * This class provides a solution to the Longest Common Substring (LCS) problem
 * using a bottom-up Dynamic Programming approach.
 * 
 * Complexity Analysis:
 * Time Complexity: O(N * M), where N and M are the lengths of the two strings.
 * Space Complexity: O(N * M), for the 2D DP table.
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        // Sample test cases: 
        // "abcde" & "abfce" would return 2 ("ab")
        // "abcdxyz" & "xyzabcd" should return 4 ("abcd")
        String str1 = "abcdxyz";
        String str2 = "xyzabcd";

        System.out.println("Length of Longest Common Substring: " + longestCommonSubstring(str1, str2));
    }

    /**
     * Finds the length of the longest common substring between two strings.
     * A substring must be a contiguous sequence of characters.
     */
    static int longestCommonSubstring(String text1, String text2) {
        int t1 = text1.length();
        int t2 = text2.length();

        // Variable to track the maximum length found during the DP table fill
        int longestCommonSubstringLength = 0;

        /*
         * Create a 2D DP table where dp[i][j] represents the length of the 
         * common substring ending at text1[i-1] and text2[j-1].
         * 
         * We add +1 to the dimensions to represent the "empty string" case (base case),
         * which simplifies the logic by avoiding index out of bounds for (i-1) or (j-1).
         */
        int[][] dp = new int[t1 + 1][t2 + 1];

        // Iterate through each character of both strings
        for (int i = 1; i <= t1; i++) {
            for (int j = 1; j <= t2; j++) {
                
                // If characters match, the common substring length increases by 1 
                // compared to the length of the substring ending at the previous characters
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    
                    // Update the global maximum length found so far
                    longestCommonSubstringLength = Math.max(longestCommonSubstringLength, dp[i][j]);
                } else {
                    /*
                     * If characters do not match, the common substring is broken.
                     * We reset dp[i][j] to 0 because we are looking for CONSECUTIVE 
                     * matches (substrings), not subsequences.
                     */
                    dp[i][j] = 0;
                }
            }
        }
        
        // Return the highest value found in the DP table
        return longestCommonSubstringLength;
    }
}
