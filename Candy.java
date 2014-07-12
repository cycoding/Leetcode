public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        
        // THIS WILL MAKE A WORST CASE OF o(n^2) so its not the best
        // for(int i = 1; i < ratings.length; i++){
        //     if(ratings[i] == ratings[i-1])
        //         num[i] = num[i-1];
        //     else if(ratings[i] > ratings[i-1])
        //         num[i] = num[i-1]+1;
        //     else{
        //         num[i] = num[i-1]-1;
        //         if(num[i] <= 0){
        //             //increase all values before and bigger than it by 1
        //             num[i] = 1;
        //             int temp = i-1;
        //             while(temp >= 0 && ratings[temp] > ratings[temp+1]){
        //                 num[temp]++;
        //                 temp--;
        //             }
        //         }
        //     }
        // }
        
        // in fact we only need to satisfy the requirements in two steps:
        // 1> from left to right, make num[i]>num[i-1] if rating[i]>rating[i-1]
        // 2> from right to left, make num[i]>num[i+1] if rating[i]>rating[i+1]
        // now we need to get the larger of the two to satisfy both conditions
        
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        left[0] = 1;
        right[ratings.length-1] = 1;
        
        for(int i = 1; i < ratings.length; i++)
            left[i] = ratings[i]>ratings[i-1] ? left[i-1]+1 : 1;
        for(int i = ratings.length-2; i >=0 ; i--)
            right[i] = ratings[i]>ratings[i+1] ? right[i+1]+1 : 1;

        int sum = 0;
        for(int i = 0; i < ratings.length; i++)
            sum += Math.max(left[i], right[i]);
        return sum;
    }
}
