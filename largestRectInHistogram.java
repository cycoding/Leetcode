public class Solution {
    public int largestRectangleArea(int[] height) {
        // find the max area of each bar as lowest bar
        // it's really important to understand the actual meaning of each situation
        if(height == null || height.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i < height.length; i++){
            if(stack.empty() || height[i] >= height[stack.peek()])
                stack.push(i);
            else{
                // top of current stack can't be the lowest bar
                int pos = stack.pop();
                if(stack.empty())
                    // meaning: the bar at pos is the lowest one in [0, i], not [0, pos+1]
                    max = Math.max(max, height[pos]*i);
                else
                    // meaning: the bar at pos is shortest one in [stack.peek(), i]
                    max = Math.max(max, height[pos]*(i-stack.peek()-1));
                i--;
            }
        }
        // if stack is not empty, then it stores increasing height of bars
        while(!stack.empty()){
            int pos = stack.pop();
            if(!stack.empty())
                // meaning: the bar at pos is the lowest bar in [stack.peek(), height.length];
                max = Math.max(max, height[pos]*(height.length-stack.peek()-1));
            else
                // meaning: the bar at pos is the lowest one in the whole array
                max = Math.max(max, height[pos]*height.length);
        }
        return max;
    }
}
