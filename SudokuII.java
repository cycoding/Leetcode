public class Solution {
    public void solveSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][] square = new int[9][9];
        
        //get the situation of numbers on each row, column and square
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    int num = Character.getNumericValue(board[i][j])-1;
                    int s = (i/3)*3 + j/3;
                    row[i][num]++;
                    column[j][num]++;
                    square[s][num]++;
                }
            }
            
        dfs(board, 0, row, column, square);
    }
    //here we need to set this method to boolean type
    public boolean dfs(char[][] board, int pos, int[][] row, int[][] column, int[][] square){
        if(pos == board.length*board[0].length)
            return true;
            
        int i = pos/9;
        int j = pos - (pos/9)*9;
        int s = (i/3)*3 + j/3;
        if(board[i][j] != '.')
            return dfs(board, pos+1, row, column, square);
        else{

            List<Integer> nums = findValid(pos, row, column, square);
            
            for(int num : nums){
                board[i][j] = Character.forDigit(num, 10);
                int temp = num - 1;
                row[i][temp]++;
                column[j][temp]++;
                square[s][temp]++;
                //if its not boolean type, then every thing would be recovered
                if(dfs(board, pos+1, row, column, square))
                	return true;
                board[i][j] = '.';
                row[i][temp]--;
                column[j][temp]--;
                square[s][temp]--;
            }
            return false;
        }
    }
    //get a list of valid numbers to put
    public List<Integer> findValid(int pos, int[][] row, int[][] column, int[][] square){
        List<Integer> res = new ArrayList<Integer>();
        int i = pos/9;
        int j = pos - (pos/9)*9;
        int s = (i/3)*3 + j/3;
        int[] exist = new int[9];
        for(int index = 0; index < row[i].length; index++){
            if(row[i][index] == 1)
                exist[index]++;
        }
        for(int index = 0; index < column[j].length; index++){
            if(column[j][index] == 1)
                exist[index]++;
        }
        for(int index = 0; index < square[s].length; index++){
            if(square[s][index] == 1)
                exist[index]++;
        }
        for(int index = 0; index < exist.length; index++){
            if(exist[index] == 0){
                int temp = index + 1;
                res.add(temp);
            }
        }
        return res;
    }
}
