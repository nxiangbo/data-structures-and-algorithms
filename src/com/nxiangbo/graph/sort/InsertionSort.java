package com.nxiangbo.graph.sort;

public class InsertionSort {
	public void sort(Comparable[] a){
		int n = a.length;
		for(int i=1;i<n;i++){
			for(int j=i;j>0&&less(a,j,j-1);j--){
				swap(a, j, j-1);
			}
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
		
	}
}
