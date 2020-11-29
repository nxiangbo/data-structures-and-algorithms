package com.nxiangbo.dynamicprograming;

public class CountingBits {
	public static int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
        	n = n&(n-1);
        	count++;
        }
        return count;
    }
	
	public static int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 0; i <= num; i++) {
			res[i] = hammingWeight(i);
		}
        return res;
    }
	
	public static void main(String[] args) {
		int n = 11;
		 int[] res = new int[n+1];
		 res = countBits(n);
		 for (int i : res) {
			System.out.println(i);
		}
//		System.out.println(countBits(n));
	}
}
