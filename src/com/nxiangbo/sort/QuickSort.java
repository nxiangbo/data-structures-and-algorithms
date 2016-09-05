package com.nxiangbo.sort;

import java.util.Random;

public class QuickSort {
	public void sort(Comparable[] a){
		shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	public void sort(Comparable[] a, int low, int high){
		if(low<high){
			int j = partition(a, low, high);
			sort(a, low, j-1);
			sort(a, j+1, high);
		}
	}

	private int partition(Comparable[] a, int low, int high) {
		Comparable pivot = a[low];
		while(low<high){
			while(low<high && pivot.compareTo(a[high])<=0) high--;
			a[low] = a[high];
			while(low<high && pivot.compareTo(a[low])>=0) low++;
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}
	
	public boolean less(Comparable a, Comparable b){
		return a.compareTo(b)<0;
	}
	
	public void swap(Comparable[] a, int i, int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void swap(Comparable a, Comparable b){
		Comparable temp = a;
		a = b;
		b = temp;
	}
	
	public void shuffle(Comparable[] a){
		int n = a.length;
		Random random = new Random();
		for(int i=0;i<n;i++){
			int r = random.nextInt(n-i)+i;
			swap(a, i, r);
		}
	}
	
	public void print(Comparable[] a){
		for (Comparable com : a) {
			System.out.print(com+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] nums = {1,3,2,4,5};
		QuickSort qSort = new QuickSort();
		qSort.sort(nums);
		qSort.print(nums);
	}
}
