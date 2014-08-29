public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0)
            return;
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = bottom;
        while(top < bottom){
            for(int i = left; i < right; i++){
                // this delta here is used to calculate relative position
                int delta = i - left;
                int temp = matrix[top][i];
                matrix[top][i] = matrix[bottom-delta][left];
                matrix[bottom-delta][left] = matrix[bottom][right-delta];
                matrix[bottom][right-delta] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
    }
}