public class Solution {
    public int jump(int[] A) {
        if(A == null || A.length == 1)
            return 0;
        //greedy algorithm is better here
        //at every step, we check to see the farest position we could be
        int minStep = 0;
        int start = 0;
        int end = A[start];
        
        if(end >= A.length - 1)
            return minStep+1;
        //right now we stand at the range of [start, end]
        while(end < A.length - 1){
            //we go one more step so we are now in [start, end] range
            minStep++;
            //we need to calculate the furthest we could be in our range for our next step
            int max = 0;
            for(int j = start; j <= end; j++){
                int current = j + A[j];
                if(current >= A.length - 1)
                    return minStep+1;
                //now we are updating the furthest position we could be in next step
                max = Math.max(max, current);
            }
            start = end + 1;
            end = max;
        }
        return -1;
    }
}
