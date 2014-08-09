public class Solution {
    // the core idea is that, when you partition a string from a position, the two substrings will always 
    // remain as two separate ones, although characters inside may change positions. but the two would always
    // remain as a whole to each other
    public boolean isScramble(String s1, String s2) {
        // if two strings are the same then definitely they are scramble strings
        // only when they are not equal do we need to check
		if(s1.equals(s2))
			return true;
        int len = s1.length();
        for(int i = 0; i < len-1; i++){
            String s11 = s1.substring(0, i+1);
            String s12 = s1.substring(i+1, len);
            String s21 = s2.substring(0, i+1);
            String s22 = s2.substring(i+1, len);
            String s23 = s2.substring(0, len-i-1);
            String s24 = s2.substring(len-i-1, len);
            
            if((isAnagram(s11, s21) && isAnagram(s12, s22) && isScramble(s11, s21) && isScramble(s12, s22)) 
            || (isAnagram(s11, s24) && isAnagram(s12, s23) && isScramble(s11, s24) && isScramble(s12, s23)))
                return true;
        }
        return false;
    }
    public boolean isAnagram(String s1, String s2){
        int[] chars = new int[256];
        for(int i = 0; i < s1.length(); i++){
            chars[s1.charAt(i)]++;
            chars[s2.charAt(i)]--;
        }
        for(int i : chars){
            if(i != 0)
                return false;
        }
        return true;
    }
}
