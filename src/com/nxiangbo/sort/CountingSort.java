package com.nxiangbo.sort;

public class CountingSort {
	public static void sort(int[] a, int[] b,  int k){
		int[] c = new int[k];
		for(int i=0;i<a.length;i++){
			c[a[i]]++;
			
		}
		
		for(int i=1;i<k;i++){
			c[i] = c[i]+c[i-1];
		}
		
		for(int i=a.length-1;i>=0;i--){
			b[c[a[i]]-1] = a[i];
			c[a[i]] = c[a[i]]-1;
		}
	}
	
	public static void sort(int[] a, int k){
		int[] c = new int[k];
		for(int i=0;i<a.length;i++){
			c[a[i]]++;
		}
		
		int index=0;
		for(int i=0;i<k;i++){
			for(int j=0;j<c[i];j++){
				a[index++] = i;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,4,5,2,1,4,2,6,8,2};
		int[] b = new int[10];
		int k = 9;
		sort(nums, k);
		for (int i : nums) {
			System.out.print(i+", ");
		}
		System.out.println();
	}
}
