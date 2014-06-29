public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A.length == 1)
            return A[0] == 1 ? 2 : 1;
        int end = A.length;
        int i = 0;
        while(i < end){
            //we keep swapping utill the ith position stores (i+1) so we achieve sorting
            // unless the number is out of range
            while(A[i] != i+1){
                if(A[i]<=0 || A[i]>end || A[i]==A[A[i]-1])
                    break;
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
            }
            i++;
        }
        //iterate through the array, find the first one that is not right
        for(i = 0; i < end; i++){
            if(A[i] != i+1)
                return i+1;
        }
        return end+1;
    }
}