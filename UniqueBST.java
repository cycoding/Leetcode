public class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        // base case
        dp[0] = 1;
        dp[1] = 1;
        // fill in the dp array
        // the idea is that, there is no considering the numbers, instead,
        // if we consider [1, n], if we make k as the root, there are k-1 numbers on the left and n-k on the right
        // so dp[n] = dp[k]*dp[n-k];
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
