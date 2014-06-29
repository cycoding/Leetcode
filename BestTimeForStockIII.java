public class Solution {
    public int maxProfit(int[] prices) {
        //this could be solved in o(n) complexity
        if(prices == null || prices.length < 2)
            return 0;
            
        int max_left[] = new int[prices.length];
        int max_right[] = new int[prices.length];
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]-min);
            max_left[i] = max;
        }
        
        // since it's a reversed process, pay attention to first get the maximum price and then get the maximum profit
        max = Integer.MIN_VALUE;
        int max_profit = Integer.MIN_VALUE;
        for(int i = prices.length-1; i >= 0; i--){
            max = Math.max(max, prices[i]);
            max_profit = Math.max(max_profit, max - prices[i]);
            max_right[i] = max_profit;
        }
        
        int global_max = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++)
            global_max = Math.max(global_max, max_left[i]+max_right[i]);
        return global_max;
    }
}