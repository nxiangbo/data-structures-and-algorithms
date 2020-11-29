package com.nxiangbo.dynamicprograming;

public class PerfectSquares {
	 public static int numSquares(int n) {
		 int[] dp = new int[n+1];
		 for (int i = 0; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		 dp[0] = 0;
		 for (int i = 1; i <=n; i++) {
			for(int j = 1;j*j<=i;j++){
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
//				System.out.println("i="+i+",dp[i]"+dp[i]);
			}
		}
		 return dp[n];
		 
	 }
	 
	 public static void main(String[] args) {
		int n = 4;
		System.out.println(numSquares(n));
	}
}
