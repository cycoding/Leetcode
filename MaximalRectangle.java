public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int max_area = 0;
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        int height[] = new int[cLen];
        for(int i = 0; i < rLen; i++){
            //in every row, calculate the largest rectangle area of the histogram formed by it and all the rows above
            // for diagram, look at http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html
            int j = 0;
            for(; j < cLen; j++){
                if(matrix[i][j] == '1')
                    height[j] += 1;
                else
                    height[j] = 0;
            }
            
            Stack<Integer> s = new Stack<Integer>();
            for(j = 0; j < cLen; j++){        
                if(s.empty() || height[s.peek()] <= height[j])
                    s.push(j);
                else{
                    int pos = s.pop();
                    // if the stack is empty, meaning the bar is smallest in [0, j), not [0, pos]
                    int size = s.empty() ? height[pos]*j : height[pos]*(j-s.peek()-1);
                    max_area = Math.max(max_area, size);
                    j--;
                }
            }
            while(!s.empty()){
                int pos = s.pop();
                int size = s.empty() ? height[pos]*j : height[pos]*(j-s.peek()-1);
                max_area = Math.max(max_area, size);
            }
        }
        return max_area;
    }
}