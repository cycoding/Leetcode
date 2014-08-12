public class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices == null || prices.length == 0)
        	return res;
        int prev = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prev)
                res += prices[i]-prev;
            prev = prices[i];
        }
        return res;
    }
}
