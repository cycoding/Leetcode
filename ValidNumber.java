public class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0)
            return false;
        //first trim the s
        s = s.trim();
        if(s.equals(""))
            return false;
        //then get possible signs
        if(s.startsWith("-") || s.startsWith("+"))
            s = s.substring(1);
        //get successive numbers
        int i = 0;
        StringBuffer sb = new StringBuffer();
        //find subsequent numbers
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9')
            sb.append(s.charAt(i++));
        
        //if its empty and following is not . then false
        if(sb.length() == 0 && s.charAt(i) != '.')
            return false;
        boolean prev = sb.length() == 0;
        if(i == s.length())
            return true;
            
        //then if its followed by . we make sure there are numbers following
        if(s.charAt(i) == '.'){
            boolean after = true;
        	i++;
            while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                i++;
                after = false;
            }
            if(prev && after)
                return false;
            if(i == s.length())
                return true;
        }
        //then look at its subsequent chars
        if(s.charAt(i++) != 'e' || i == s.length())
            return false;
            
        s = s.substring(i);
        //then we look at the numbers after e
        if(s.startsWith("-") || s.startsWith("+"))
            s = s.substring(1);
        if(s.equals(""))
            return false;
        int start = 0;
        while(start < s.length()){
            char ch = s.charAt(start);
            if(ch < '0' || ch > '9')
                return false;
            start++;
        }
        return true;
    } 
}