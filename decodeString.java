public class Solution {
    public int numDecodings(String s) {
        //DP problem
        // for the ith number, we decide if it must be decoded with its previous character or separately or both is okay
        if(s == null || s.length() == 0)
            return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        
        if(s.charAt(0) == '0')
            return 0;
        dp[1] = 1;
        
        for(int i = 1; i < s.length(); i++){
            char prev = s.charAt(i-1);
            char cur = s.charAt(i);
            // if current number is 0, it must be decoded together with its previous character, which must be 1 or 2
            if(cur == '0') {
                if(prev == '1' || prev == '2')
                    dp[i+1] = dp[i-1];
                else
                    return 0;
            }
            // if it is not 0, then it could be decoded either separately or in combination
            else {
                if(prev == '1' || (prev == '2' && cur <= '6'))
                    dp[i+1] = dp[i] + dp[i-1];
                else
                    dp[i+1] = dp[i];
            }
        }
        
        return dp[s.length()];
    }
}
