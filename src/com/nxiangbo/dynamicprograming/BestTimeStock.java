package com.nxiangbo.dynamicprograming;

public class BestTimeStock {
	//±©Á¦½â
	public static int bestTimeBuyAndSellStock(int[] prices){
		if(prices.length<=0){
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				max = Math.max(max, prices[j]-prices[i]);
			}
		}
		return max;
	}
	
	/**
	 * Kadane's Algorithm
	 * @param prices
	 * @return
	 */
	public static int bestTimeBuyAndSellStockWithDP(int[] prices){
		if(prices.length<=0){
			return 0;
		}
		
		int thisSum = 0;
		int maxSum = 0;
		for (int i = 1; i < prices.length; i++) {
			thisSum +=prices[i]-prices[i-1];
			thisSum = Math.max(0, thisSum);
			maxSum = Math.max(maxSum,thisSum);
		}
		return maxSum;
	}
	
	public static int bestTimeBuyAndSellStockWithDP2(int[] prices){
		if(prices.length<=0){
			return 0;
		}
		
		int minPrices = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			minPrices = Math.min(minPrices, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i]-minPrices);
		}
		return maxProfit;
	}
	
	public static void main(String[] args) {
		int[] prices = {0, 6, -3, 7};
		System.out.println(bestTimeBuyAndSellStockWithDP2(prices));
	}
}
