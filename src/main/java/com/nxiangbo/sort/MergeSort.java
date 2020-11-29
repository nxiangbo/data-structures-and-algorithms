package com.nxiangbo.sort;

public class MergeSort {
	private Comparable[] aux;
	
	public void sortBU(Comparable[] a){
		aux = new Comparable[a.length];
		int n = a.length;
		for(int sz=1;sz<n;sz = sz+sz){
			for(int low=sz;low<n-sz;low+=sz+sz){
				merge(a, low, low+sz-1, Math.min(low+sz+sz-1, n-1));
			}
		}
	}
	
	public void sort(Comparable[] a){
		aux = new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	
	public void sort(Comparable[] a, int low, int high){
		if(low<high){
			int mid = (low+high)/2;
			sort(a, low, mid);
			sort(a, mid+1, high);
			merge(a, low, mid, high);
		}
	}
	
	public void merge(Comparable[] a, int low, int mid, int high){
		int i = low, j = mid+1;
		for(int k = low; k<=high; k++){
			aux[k] = a[k];
		}
		
		for(int k = low;k<=high;k++){
			if(i>mid) a[k] = aux[j++];
			else if(j>high) a[k] = aux[i++];
			else if(less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
	}
	
	public boolean less(Comparable a, Comparable b){
		return a.compareTo(b)<0;
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
		Integer[] nums = {1,3,2,4,5};
		MergeSort mSort = new MergeSort();
		mSort.sortBU(nums);
		mSort.print(nums);
	}
}
