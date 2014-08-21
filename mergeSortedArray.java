public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if(A == null || B == null)
            return;
        int i = m-1;
        int j = n-1;
        //fill in the array from top so that it won't overwrite
        while(i >= 0 && j >= 0){
            if(A[i] >= B[j])
                A[i+j+1] = A[i--];
            else
                A[i+j+1] = B[j--];
        }
        if(i < 0){
            while(j >= 0)
                A[i+j+1] = B[j--];
        }
        else {
            while(i >= 0)
                A[i+j+1] = A[i--];
        }
        return;
    }
}
