public class Solution {
    public int largestRectangleArea(int[] height) {
        //reference:http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
        //elegant way of calculating: calculate the size of each bar as smallest bar in a rectangle
        if(height == null || height.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int size = 0;
        int max_area = 0;
        int i = 0;
        for(; i < height.length; i++){
            if(stack.empty() || height[i] >= height[stack.peek()])
                stack.push(i);
            else{
                int low = stack.pop();
                //if the stack is empty, meaning this bar is the smallest from [0, i), so the width is i;
                //if the stack not empty, meaning this bar is the smallest in (stack.peek(), i), so width is i-stack.peek()-1
                size = height[low]*(stack.empty() ? i : i-stack.peek()-1);
                max_area = Math.max(max_area, size);
                i--;
            }
        }
        //finally when stack is not empty, meaning all bars are in increasing order, then pop and calculate them one by one
        //at this time the stack is left with bars which are smallest to its right, so its width should be to height.length
        while(!stack.empty()){
            int low = stack.pop();
            //take care that we are still using i here, which is height.length
            size = height[low]*(stack.empty() ? i : i-stack.peek()-1);
            max_area = Math.max(max_area, size);
        }
        return max_area;
    }
}