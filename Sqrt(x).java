public class Solution {
    public int sqrt(int x) {
        if(x < 1)
            return 0;
        int low = 1;
        int high = x;// we could further set high to be x/2+1
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            // instead of using mid*mid which may cause overflow, we use x/mid
            if(x/mid < mid)
                high = mid - 1;
            else if(x/mid > mid)
                low = mid + 1;
            else
                return mid;
        }
        //since low is getting bigger and high is getting smaller, we need to use to smaller one
        return high;
        
        // another solution with Newton's method
        // int initial = x;
        // int result = 0;
        // while(true){
        //     result = (int)Math.floor((initial+Math.floor(x/initial))/2);
        //     if(result >= initial)
        //         return initial;
        //     else
        //         initial = result;
        // }
    }
}