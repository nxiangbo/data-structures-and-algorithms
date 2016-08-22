package com.nxiangbo.dynamicprograming;

public class MinimumPathSum {
	 public static int minPathSum(int[][] grid) {
		 if(grid==null){
			 return Integer.MIN_VALUE;
		 }
		 
		 int rows = grid.length;
		 int colmns = grid[0].length;
		 for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colmns; j++) {
				if(i==0&&j!=0){
					grid[i][j] = grid[i][j-1]+grid[i][j];
				}
				if(i!=0&&j==0){
					grid[i][j] = grid[i-1][j]+grid[i][j];
				}
				if(i!=0&&j!=0){
					grid[i][j] = Math.min(grid[i-1][j]+grid[i][j], grid[i][j-1]+grid[i][j]);
				}
			}
		}
		 return grid[rows-1][colmns-1];
		 
	 }
	 
	 public static void main(String[] args) {
		int[][] grid = {
					{0,1,3,0},
					{2,4,6,5},
					{7,3,0,4},
					{2,9,10,0}};
		System.out.println(minPathSum(grid));
	}
}
