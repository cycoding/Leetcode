public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++){
            if(!isOperator(tokens[i]))
                stack.push(Integer.parseInt(tokens[i]));
            else{
                if(stack.size() < 2)
                    return 0;
                int op2 = stack.pop();
                int op1 = stack.pop();
                switch(tokens[i]){
                    case "+":
                        stack.push(op1+op2);
                        break;
                    case "-":
                        stack.push(op1-op2);
                        break;
                    case "*":
                        stack.push(op1*op2);
                        break;
                    case "/":
                        if(op2 == 0)
                            return 0;
                        stack.push(op1/op2);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();
    }
    public boolean isOperator(String str){
        if(str.equals("+") || str.equals("-") ||str.equals("*") ||str.equals("/"))
            return true;
        return false;
    }
}
