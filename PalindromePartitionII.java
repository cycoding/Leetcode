public class Solution {
    public int minCut(String s) {
        //idea from word-break
        if(s == null || s.length() == 0)
            return 0;
            
        boolean palin[][] = new boolean[s.length()][s.length()];
        int count[][] = new int[s.length()][s.length()];
        
        //initialize the count array
        for(int i = 0; i < count.length; i++)
            for(int j = 0; j < count.length; j++){
                if(i == j)
                    count[i][j] = 1;
                else
                    count[i][j] = Integer.MAX_VALUE;
            }
        //here we modify to get palin[][] in o(n2)
        for(int i = 0; i < s.length(); i++)
            for(int j = 0; j < s.length() - i; j++){
                if( i == 0)
                    palin[j][j] = true;
                else if( i== 1)
                    palin[j][j+1] = (s.charAt(j) == s.charAt(j+1)) ? true : false;
                else
                    palin[j][i+j] = (s.charAt(j) == s.charAt(i+j)) ? palin[j+1][i+j-1] : false;
            }
            
        for(int i = 0; i < s.length(); i++)
            for(int j = i; j < s.length(); j++){
                if(palin[i][j]){
                    if(i == 0)
                        count[0][j] = 1;
                    //here, if (i,j) is a palindrome, then (0,j) could be modified
                    if(i > 0)
                        count[0][j] = Math.min(count[0][j], count[0][i-1]+1);
                }
            }
        return count[0][s.length()-1]-1;
    }
}