public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null)
            return false;
        // Method 1 ===> intuitive method
        // StringBuffer sb = new StringBuffer();
        // for(int i = 0; i < s.length(); i++){
        //     char ch = s.charAt(i);
        //     if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))
        //         sb.append(("" + ch).toLowerCase());
        // }
        // if("".equals(sb.toString()))
        //     return true;
        // Method 2 ====> we could use regrex
        String temp =  s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        for(int i = 0; i < temp.length()/2; i++){
            if(temp.charAt(i) != temp.charAt(temp.length()-1-i))
                return false;
        }
        return true;
    }
}
