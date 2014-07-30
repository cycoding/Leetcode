public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0] == 0)
            dp[0][0] = 1;
        else
            return 0;
        //base case
        int column = 1;
        int line = 1;
        while(column < obstacleGrid[0].length && obstacleGrid[0][column] == 0)
            dp[0][column++] = 1;
        while(line < obstacleGrid.length && obstacleGrid[line][0] == 0)
            dp[line++][0] = 1;
        //fill in other cells
        for(line = 1; line < obstacleGrid.length; line++)
            for(column = 1; column < obstacleGrid[0].length; column++){
            	if(obstacleGrid[line][column] == 1)
            		dp[line][column] = 0;
            	else
            		dp[line][column] = dp[line-1][column] + dp[line][column-1];
            }
        return dp[dp.length-1][dp[0].length-1];
    }
}
