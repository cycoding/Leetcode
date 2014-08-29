public class Solution {
    public int searchInsert(int[] A, int target) {
        // best explanation: http://canhazcode.blogspot.com/2012/02/we-need-to-talk-about-binary-search.html
        if(A == null || A.length == 0)
            return 0;
        return insert(A, target, 0, A.length-1);
    }
    public int insert(int[] A, int target, int low, int high){
        if(low > high)
            return low;
        int mid = (low + high)/2;
        // if mid smaller than target, meaning the lower half could be ignored
        if(A[mid] < target)
            return insert(A, target, low+1, high);
        // else, we find a potential answer: low, but still, we narrow down to find possible smallest one.
        return insert(A, target, low, high-1);
    }
}