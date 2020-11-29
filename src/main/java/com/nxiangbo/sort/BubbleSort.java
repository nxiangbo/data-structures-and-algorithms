package com.nxiangbo.sort;

public class BubbleSort {
	public void sort(Comparable[] a){
		int n = a.length;
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-1-i;j++){
				if(less(a,j+1,j)){
					swap(a,j,j+1);
				}
			}
			
			print(a);
		}
	}
	
	public boolean less(Comparable[] a, int i, int j){
		return a[i].compareTo(a[j])<0;
	}
	
	public void swap(Comparable[] a, int i, int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void print(Comparable[] a){
		for (Comparable com : a) {
			System.out.print(com+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] nums = {12,43,2,32,23};
		BubbleSort bsort = new BubbleSort();
		bsort.sort(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
