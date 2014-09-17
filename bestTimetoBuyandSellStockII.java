public class Solution {
    public int maxProfit(int[] prices) {
        // since we can complete as many transactions as possible
        // then as long as there is an increasing loop, we add the gap
        if(prices == null || prices.length == 0)
            return 0;
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            max += (prices[i] > prices[i-1]) ? (prices[i] - prices[i-1]) : 0;
        }
        return max;
    }
}