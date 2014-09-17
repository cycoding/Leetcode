public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null) 
            return 0;
        // String[] split = s.trim().split("\\s+");
        // if(split.length == 0)
        //     return 0;
        // return split[split.length-1].length();
        int res = 0;
        s = s.trim();
        int i = s.length()-1;
        while(i >= 0 && s.charAt(i) != ' '){
            res++;
            i--;
        }
        return res;
    }
}
