public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null)
            return false;
        return dfs(s, p, 0, 0);
    }
    public boolean dfs(String s, String p, int ss, int ps){
        if(ps == p.length())
            return ss==s.length();
        //it comes to two situations: next char is * or not
        //if next not *, then current char in p must match current one in s
        if(ps == p.length()-1 || p.charAt(ps+1) != '*'){
            if(ss >= s.length() || (s.charAt(ss) != p.charAt(ps) && p.charAt(ps) != '.'))
                return false;
            return dfs(s, p, ss+1, ps+1);
        }
        //if next is *, then we can match 0 to s.length()-ss characters in s
        int start = ss-1; //notice here we have to set start to be smaller than ss
        char ch = p.charAt(ps);
        while(start < s.length() && (start < ss || ch == '.' || s.charAt(start) == ch)){
            if(dfs(s, p, start+1, ps+2))
                return true;
            start++;
        }
        return false;
    }
}