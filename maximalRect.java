public class Solution {
    public int maximalRectangle(char[][] matrix) {
    // use maxrectangele in histogram
        if(matrix == null || matrix.length == 0)
            return 0;
        int histo[] = new int[matrix[0].length];
        int max = 0;
        
        for(int i = 0; i < matrix.length; i++){
            // iterate through matrix[i] to update histo
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1')
                    histo[j] += 1;
                else
                    histo[j] = 0;
            }
            // use histogram to get max rectangle
            int local_max = getMaxRect(histo);
            max = Math.max(max, local_max);
        }
        return max;
    }
    
    public int getMaxRect(int[] histo){
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < histo.length; i++){
            if(stack.empty() || histo[i] >= histo[stack.peek()])
                stack.push(i);
            // if current is smaller than stack, pop it out
            else {
                int pos = stack.pop();
                if(stack.empty())
                    max = Math.max(max, histo[pos]*i);
                else
                    max = Math.max(max, histo[pos]*(i-stack.peek()-1));
                // don't forget this i-- since we need to reinsert this element again
                i--;
            }
        }
        // the remaning ones are increasing
        while(!stack.empty()){
            int pos = stack.pop();
            if(!stack.empty())
                max = Math.max(max, histo[pos]*(histo.length-stack.peek()-1));
            else
                max = Math.max(max, histo[pos]*histo.length);
        }
        return max;
    }
}
