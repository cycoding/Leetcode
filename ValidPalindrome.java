public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() < 2)
            return true;
            
        s = s.toLowerCase();
        StringBuffer clean = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if((ch >= 48 && ch <= 57) || (ch >= 97 && ch <= 122))
                clean.append(ch);
        }
        s = clean.toString();
        
        int start = 0;
        int end = s.length() - 1;
        
        while(start <= end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else
                return false;
        }
        return true;
    }

}