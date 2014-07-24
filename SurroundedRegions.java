public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0)
            return;
        if(board.length <= 2 || board[0].length <= 2)
            return;
        boolean[][] unchanged = new boolean[board.length][board[0].length];
        Stack<Integer> x = new Stack<Integer>();
        Stack<Integer> y = new Stack<Integer>();
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O'){
                x.push(i);
                y.push(0);
            }
            if(board[i][board[0].length - 1] == 'O'){
                x.push(i);
                y.push(board[0].length - 1);
            }
        }
        for(int j = 0; j < board[0].length; j++){
            if(board[0][j] == 'O'){
                x.push(0);
                y.push(j);
            }
            if(board[board.length - 1][j] == 'O'){
                x.push(board.length - 1);
                y.push(j);
            }
        }
        //then we begin to iterate to find all O that don't have to change, change all unchanged O to N
        while(x.size() > 0){
            int i = x.pop();
            int j = y.pop();
            board[i][j] = 'N';
            if(i > 0 && board[i-1][j] == 'O'){
                x.push(i-1);
                y.push(j);
            }
            if(j > 0 && board[i][j-1] == 'O'){
                x.push(i);
                y.push(j-1);
            }
            if(i <= board.length - 2 && board[i+1][j] == 'O'){
                x.push(i+1);
                y.push(j);
            }
            if(j <= board[0].length - 2 && board[i][j+1] == 'O'){
                x.push(i);
                y.push(j+1);
            }
        }
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'N')
                    board[i][j] = 'O';
            }
    }
}
