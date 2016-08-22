package com.nxiangbo.dynamicprograming;

public class UniquePath {
	public static int uniquePaths(int m, int n) {
        if(m<=0||n<=0){
        	return -1;
        }
        
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
			paths[i][0] = 1;
		}
        for (int j = 0; j < n; j++) {
			paths[0][j] = 1;
		}
        for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				paths[i][j] = paths[i-1][j]+paths[i][j-1];
			}
		}
        return paths[m-1][n-1];
        
    }
	
	public static  int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = (obstacleGrid[0][0]==0?1:0);
		for (int i = 1; i < m; i++) {
			dp[i][0] = (dp[i-1][0]==1&&obstacleGrid[i][0]==0)?1:0;
		}
		for (int j = 1; j < n; j++) {
			dp[0][j] = (dp[0][j-1]==1&&obstacleGrid[0][j]==0)?1:0;
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if(obstacleGrid[i][j]==1){
					dp[i][j] = 0;
				} else{
					dp[i][j] = dp[i-1][j]+dp[i][j-1];
				}
			}
		}
		return dp[m-1][n-1];
    }
	
	public static void main(String[] args) {
		int m = 3, n= 3;
		System.out.println(uniquePaths(m, n));
		
		int[][] obs = {
				{1,0}
		};
		
		System.out.println(uniquePathsWithObstacles(obs));
	}
}
