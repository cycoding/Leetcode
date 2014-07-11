public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) 
            return 0;
        int max_g = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        char[] chs = s.toCharArray();
        
        //a very good method to flag every two matched parenthesis
        for(int i = 0; i < chs.length; i++){
            if(chs[i] == '(')
                stack.push(i);
            else{
                if(!stack.empty()){
                    int match = stack.pop();
                    chs[i] =  '0';
                    chs[match] = '0';
                }
            }
        }
        //then traverse the string again to find longest sequential 0s
        for(int i = 0; i < chs.length; i++){
            if(chs[i] == '0')
                max++;
            else{
                max_g = Math.max(max_g, max);
                max = 0;
            }
        }
        max_g = Math.max(max_g, max);
        return max_g;
    }
}
