public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        int prev = A[0];
        int i = 1;
        int count = 0;
        while(i < A.length){
            if(A[i] == prev)
                count++;
            else{
                prev = A[i];
                A[i-count] = prev; 
            }
            i++;
        }
        return A.length - count;
    }
}
