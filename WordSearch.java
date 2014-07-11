public class Solution {
    //the key to avoid TLE is to terminate dfs as soon as possible
    public boolean exist(char[][] board, String word) {
        if(word == null || board == null)
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                //once we find a true answer, break the for loop
                if(dfs(board, word, visited, i, j, ""))
                    return true;
            }
        return false;
    }
    public boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, String s){
        
        if(s.length() > word.length())
            return false;
        //then go to four different directions
        visited[i][j] = true;
        s += board[i][j]+"";
        //if we find the word, return true
        if(word.equals(s))
            return true;
        //if at this time the string is not part of the word, meaning we can't get the word from this string, 
        //recover what we have done and return false to terminate useless dfs
        if(!word.startsWith(s)){
        	visited[i][j] = false;
    		return false;
        }
        //same for the four directions. once we get a true return, stop other directions
        if(i > 0 && !visited[i-1][j] && dfs(board, word, visited, i-1, j, s))
            return true;
        if(i < board.length - 1 && !visited[i+1][j] && dfs(board, word, visited, i+1, j, s))
            return true;
        if(j > 0 && !visited[i][j-1] && dfs(board, word, visited, i, j-1, s))
            return true;
        if(j < board[0].length - 1 && !visited[i][j+1] && dfs(board, word, visited, i, j+1, s))
            return true;
        
        //if not getting right answer from this position, recover what we have done and go to another loop
        visited[i][j] = false;
        return false;
    }
}
