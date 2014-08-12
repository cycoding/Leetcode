public class Solution {
    public int trap(int[] A) {
        // first find the left and right max height bar for each bar
        int[] right = new int[A.length];
        int[] left = new int[A.length];
        int maxV = 0;
        for(int i = A.length - 1; i >= 0; i--){
            right[i] = (maxV < A[i]) ? -1 : maxV;
            maxV = Math.max(A[i], maxV);
        }
        maxV = 0;
        for(int i = 0; i < A.length; i++){
            left[i] = (maxV < A[i]) ? -1 : maxV;
            maxV = Math.max(A[i], maxV);
        }
        
        int res = 0;
        for(int i = 0; i < A.length; i++){
            if(left[i] != -1 && right[i] != -1){
                int delta = Math.min(left[i], right[i]);
                res += delta - A[i];
            }
        }
        return res;
    }
}