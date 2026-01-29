package dynamicProgramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "bdefg";
        String str2 = "bfg";

        System.out.println("str1, str2: " + longestCommonSubsequence(str1, str2));
    }

    static String longestCommonSubsequence(String text1, String text2){
        int s1 = text1.length();
        int s2 = text2.length();

        // dp[i][j] will store the length of the LCS of text1[0...i-1] and text2[0...j-1]
        int[][] dp = new int[s1+1][s2+1];

        // Step 1: Fill the DP Table to find the maximum possible LCS length
        for(int i = 1; i <= s1; i++){
            for(int j = 1; j <= s2; j++){
                // If characters match, take the diagonal value (LCS excluding these chars) and add 1
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // If mismatch, inherit the maximum value from either skipping a char in text1 or text2
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        // Step 2: Backtrack through the DP table to reconstruct the actual LCS string
        StringBuilder sb = new StringBuilder();
        int i = s1, j = s2;

        // We start from the bottom-right corner and move towards the top-left (0,0)
        while(i > 0 && j > 0){ 
            
            // Case 1: The characters at current indices match.
            // This means this character is part of the LCS.
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                sb.append(text1.charAt(i-1)); // Add the character to our result
                i--; // Move diagonally up-left to find the previous part of the sequence
                j--;
            }
            // Case 2: Mismatch occurred. We need to follow the path of the maximum value.
            // If the cell above is greater than or equal to the cell on the left, 
            // it means the current LCS length was inherited from text1's previous prefix.
            else if (dp[i-1][j] >= dp[i][j-1]) {
                i--; // Move up
            }
            // Case 3: The cell on the left was greater.
            // The current LCS length was inherited from text2's previous prefix.
            else {
                j--; // Move left
            }
        }

        // Since we backtracked from the end to the beginning, the characters are in reverse order.
        // We reverse the StringBuilder to get the correct LCS string.
        return sb.reverse().toString();
    }
}
