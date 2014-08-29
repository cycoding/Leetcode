public class Solution {
    public int candy(int[] ratings) {
        // in fact its finding how many positions bigger than every position from both left and right
        if(ratings == null || ratings.length == 0)
            return 0;
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        int sum = 0;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1])
                left[i] = left[i-1] + 1;
        }
        for(int i = ratings.length - 1; i >= 1; i--){
            if(ratings[i-1] > ratings[i])
                right[i-1] = right[i] + 1;
            sum += Math.max(left[i], right[i]);
        }
        sum += Math.max(left[0], right[0]);
        return sum;
    }
}