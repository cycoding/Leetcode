public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null || s3.length() != s1.length()+s2.length())
            return false;
            
        //now we use DP to solve this problem
        //dp[i][j] represent if (0, i) from s1 and (0, j) from s2 matches (0, i+j) from s3
        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        //base case for either side
        for(int i = 1; i <= s1.length(); i++)
            dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0];
        for(int i = 1; i <= s2.length(); i++)
            dp[0][i] = s2.charAt(i-1) == s3.charAt(i-1) && dp[0][i-1];
            
        //then fill in other cells
        for(int i = 1; i <= s1.length(); i++)
            for(int j = 1; j <= s2.length(); j++){
                dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) ||
                           (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]);
            }
        return dp[s1.length()][s2.length()];
    }
}
