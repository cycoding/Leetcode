public class Solution {
    public int maxSubArray(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        // the problem in fact reduces to find the max sum of max sum of every position
        // for each position, if previous sum bigger than 0, then add it, if not, simply return its original value
        int sum = A[0];
        int best_so_far = sum;
        int i = 1;
        while(i < A.length){
            if(sum > 0){
                sum += A[i];
            }
            else {
                sum = A[i];
            }
            best_so_far = Math.max(best_so_far, sum);
            i++;
        }
        return best_so_far;
    }
}