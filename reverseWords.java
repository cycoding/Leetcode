public class Solution {
    public String reverseWords(String s) {
        //make sure each word has only one space
        if(s == null || s.length() == 0)
            return "";
        StringBuffer sb = null;
        s = s.trim();
        boolean space = false;
        Stack<String> stack = new Stack<String>();
        int i = 0;
        while(i < s.length()){
            sb = new StringBuffer();
            if(space){
                while(i < s.length() && s.charAt(i) == ' ')
                    i++;
                sb.append(" ");
            }
            else{
                while(i < s.length() && s.charAt(i) != ' ')
                    sb.append(s.charAt(i++));
            }
            stack.push(sb.toString());
            space = !space;
        }
        sb = new StringBuffer();
        while(stack.size() > 0)
            sb.append(stack.pop());
        return sb.toString();
    }
}