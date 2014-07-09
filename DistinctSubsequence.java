public class Solution {
    public int numDistinct(String S, String T) {
        if(S.length() < T.length() || (S.length() == T.length() && !S.equals(T)))
            return 0;
        int sub[][] = new int[S.length() + 1][T.length() + 1];
        for(int i = 0; i < sub.length; i++){
            for(int j = 0; j < sub[0].length; j++){
                if(j==0)
                    sub[i][j] = 1;
                if(j > i)
                    sub[i][j] = 0;
            }
        }
        //important to find the formula of dp
        for(int i = 1; i < sub.length; i++){
            for(int j = 1; j < sub[0].length; j++){
                sub[i][j] += sub[i-1][j];
                if(S.charAt(i-1) == T.charAt(j-1))
                    sub[i][j] += sub[i-1][j-1];
            }
        }
        return sub[S.length()][T.length()];
    }
}