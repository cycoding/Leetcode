public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2)
            return s.length();
        
        int max = 0;
        int index = 0;
        while(index < s.length()){
            StringBuffer sb = new StringBuffer();
            int pos = index;
            while(pos < s.length() && sb.indexOf(s.charAt(pos)+"") == -1)
                pos++;
            max = Math.max(max, pos-index);
            if(pos >= s.length())
                return max;
            else{
                index += sb.indexOf(s.charAt(pos)+"");
            }
        }
        return max;
    }
}
