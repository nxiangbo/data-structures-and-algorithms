package com.nxiangbo.dynamicprograming;

public class CoinChange {
	public static int coinChange(int[] coins, int amount) {
        int[] res = new int[amount+1];
        int max = amount+1;
        for (int i = 0; i < res.length; i++) {
			res[i] = max;
		}
        res[0] = 0;
        for(int i = 1; i<=amount; i++){
        	for (int j = 0; j <coins.length; j++) {
        		if(i>=coins[j]){
        			res[i] = Math.min(res[i], res[i-coins[j]]+1);
        		}
			}
        }
        
        return res[amount]>amount?-1:res[amount];
    }
	
	public static int memorizedCoinChange(int[] coins, int amount){
		int[] res = new int[amount+1];
		for (int i = 0; i < res.length; i++) {
			res[i] = amount+1;
		}
		res[0] = 0;
		return -1;
		
	}
	
	
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 10;
		System.out.println(coinChange(coins, amount));
		
		System.out.println(memorizedCoinChange(coins, amount));
	}
	
}
