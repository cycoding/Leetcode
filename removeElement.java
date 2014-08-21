public class Solution {
    public int removeElement(int[] A, int elem) {
        int occur = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == elem)
                occur++;
            else
                A[i-occur] = A[i];
        }
        return A.length - occur;
    }
}
