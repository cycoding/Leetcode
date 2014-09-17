public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        if(n == 0)
            return res;
            
        boolean avail[][] = new boolean[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                avail[i][j] = true;
                
        dfs(res, avail, 0, new String[n]);
        return res;
    }
    public void dfs(List<String[]> res, boolean[][] avail, int row, String[] solu){
        if(row == avail.length){
            // the whole point here is, to copy content of solu instead of directly passing its address since we gonna modify it
        	String[] temp = new String[solu.length];
        	System.arraycopy(solu, 0, temp, 0, solu.length);
            res.add(temp);
            return;
        }
        // for every row find avaible position to place
        StringBuffer sb = new StringBuffer();
        boolean solve = false;
        for(int i = 0; i < avail.length; i++){
            if(avail[row][i]){
                solve = true;
                sb.append('Q');
                for(int j = i+1; j < avail.length; j++)
                    sb.append('.');
                // set this row, column and diagnol to false
                boolean[][] newAvail = nullify(avail, row, i);
                solu[row] = sb.toString();
                dfs(res, newAvail, row+1, solu);
                // get all the modification back
                solu[row] = null;
                sb.setLength(i);
                sb.append('.');
            }
            else
                sb.append('.');
        }
        if(!solve)
            return;
    }
    public boolean[][] nullify(boolean[][] avail, int row, int column){
        boolean[][] res = new boolean[avail.length][avail.length];
        
        for(int i = 0; i < avail.length; i++)
            for(int j = 0; j < avail.length; j++)
                res[i][j] = avail[i][j];
                
        for(int i = 0; i < avail.length; i++){
            res[row][i] = false;
            res[i][column] = false;
            // there are two diagnol positions to consider
            int diagnol = i-row+column;
            int diagnol2 = row+column-i;
            if(diagnol >= 0 && diagnol < avail.length)
                res[i][diagnol] = false;
            if(diagnol2 >= 0 && diagnol2 < avail.length)
                res[i][diagnol2] = false;
        }
        return res;
    }
}
