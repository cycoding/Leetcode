public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0 || word2.length() == 0)
            return Math.max(word1.length(), word2.length());
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] cost = new int[word1.length()+1][word2.length()+1];
        
        for(int i = 0; i < word1.length()+1; i++)
            cost[i][0] = i;
        for(int j = 0; j < word2.length()+1; j++)
            cost[0][j] = j;
        
        for(int i = 1; i < word1.length()+1; i++){
            for(int j = 1; j < word2.length()+1; j++){
                cost[i][j] = min(cost[i-1][j]+1, cost[i][j-1]+1, w1[i-1]==w2[j-1]?cost[i-1][j-1]:(cost[i-1][j-1])+1);     
            }
        }
        return cost[word1.length()][word2.length()];
    }
    public int min(int x, int y, int z){
        return Math.min(Math.min(x, y), z);
    }
}