package com.nxiangbo.graph.sort;

public class HeapSort {
	
	public void sort(Comparable[] a){
		int n = a.length-1;
		for(int i=n/2;i>=1;i--){
			sink(a, i, n);
		}
		while(n>1){
			swap(a, 1, n--);
			sink(a, 1, n);
		}
	}
	public void swim(Comparable[] a, int k, int n){
		while(k>1 && less(a,k/2,k)){
			swap(a, k/2, k);
			k = k/2;
		}
	}
	
	public void sink(Comparable[] a, int k, int n){
		while(2*k<=n){
			int j = 2*k;
			if(j<n && less(a, j, j+1)) j++;
			if(less(a, k, j)){
				swap(a, j, k);
				k=j;
			} else{
				break;
			}
		}
	}
	
	public boolean less(Comparable[] a, int i, int j){
		return a[i].compareTo(a[j])<0;
	}
	
	public void swap(Comparable[] a, int i, int j){
		Comparable temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	
	public static void main(String[] args) {
		Integer[] nums = {0,1,23,-23,43,2};
		HeapSort hsort = new HeapSort();
		hsort.sort(nums);
		for (Integer num : nums) {
			System.out.println(num);
		}
		
	}
}
