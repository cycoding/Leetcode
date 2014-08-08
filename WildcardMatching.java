public class Solution {
    public boolean isMatch(String s, String p) {
        int star = -1;
        // here match means the position we could match but not included
        int match = -1;
        int sp = 0;
        int pp = 0;
        while(sp < s.length()){
            if(pp < p.length() &&(s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')){
                sp++;
                pp++;
            }
            else if(pp < p.length() && p.charAt(pp) == '*'){
                // meaning we could match at least sp position
                match = sp;
                star = pp;
                pp++;
            }
            else{
                if(star != -1){
                    // since we already visit the match position, we should go to its next
                    // at the same time, update the match position
                    sp = ++match;
                    pp = star + 1;
                }
                else
                    return false;
            }
        }
        if(pp == p.length())
            return true;
        for(; pp < p.length(); pp++){
                if(p.charAt(pp) != '*')
                    return false;
            }
        return true;
    }
}
