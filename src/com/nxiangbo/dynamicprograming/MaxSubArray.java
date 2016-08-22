package com.nxiangbo.dynamicprograming;

import java.util.Scanner;

public class MaxSubArray {
	
	public static int maxSubArrayWithDP(int[] nums){
		if(nums.length<=0){
			return Integer.MIN_VALUE;
		}
		
		int[] res = new int[nums.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = Integer.MIN_VALUE;
		}
		
		res[0] = nums[0];
		int maxVal = Integer.MIN_VALUE; 
		for (int i = 1; i < res.length; i++) {
			if(res[i-1]<=0){
				res[i] = nums[i];
			} else{
				res[i] = res[i-1]+nums[i];
			}
			if(res[i]>maxVal){
				maxVal = res[i];
			}
		}
		
		
		return maxVal;
	}
	
	/**
	 * 姹傚緱鏁扮粍鏈�ぇ瀛愬簭鍒椾箣鍜�
	 * @param nums
	 * @return
	 */
	public static int maxsubarray2(int[] nums){
		if(nums.length<=0){
			return Integer.MIN_VALUE;
		}
		int thisSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if(thisSum<=0){
				thisSum = nums[i];
			} else{
				thisSum+=nums[i];
			}
			
			if(thisSum>maxSum){
				maxSum = thisSum;
			}
		}
		return maxSum;
	}
	
	public static void maxSubArray3(int[] nums){
		if(nums==null || nums.length<=0){
			System.out.println("");
		}
		
		int firstIndex = 0;
		int lastIndex = 0;
		int temp =0;
		int thisSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if(thisSum<0){
				thisSum = nums[i];
				temp = i;
			} else{
				thisSum += nums[i];
			}
			if(thisSum>maxSum){
				maxSum = thisSum;
				firstIndex = temp;
				lastIndex = i;
			}
		}
		
		System.out.println(maxSum);
		System.out.println(nums[firstIndex]);
		System.out.println(nums[lastIndex]);
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			if(n==0){
				System.exit(0);
			}
			int[] numsArr = new int[n];
			for (int i = 0; i < n; i++) {
				numsArr[i] = in.nextInt();
			}
			maxSubArray3(numsArr);
		}
		
		
	}
}
