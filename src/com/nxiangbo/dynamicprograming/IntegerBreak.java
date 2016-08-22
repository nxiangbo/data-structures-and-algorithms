package com.nxiangbo.dynamicprograming;

public  class IntegerBreak {
	public static int integerBreak(int n) {
		int[] dp = new int[n+1];
		dp[1] = 1;
		for(int i = 2;i<=n;i++){
			for (int j = 1; j < i; j++) {
				//×´Ì¬×ªÒÆ·½³Ì
				dp[i] = Math.max(dp[i], Math.max(j, dp[j])*Math.max(i-j, dp[i-j]));
			}
		}
		return dp[n];
    }
	public static void main(String[] args) {
		int n = 10;
		System.out.println(integerBreak(n));
	}
}
