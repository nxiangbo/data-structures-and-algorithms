package com.nxiangbo.sort;

import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {
	public static void sort(double[] a){
		int n = a.length;
		LinkedList<Double>[] buckets = new LinkedList[n];
		for(int i=0;i<n;i++){
			int index = (int) (n*a[i]);
			if(buckets[index]==null){
				buckets[index] = new LinkedList<>();
			} 
			buckets[index].add(a[i]);
		}
		
		for(int i=0;i<n;i++){
			if(buckets[i]!=null){
				Collections.sort(buckets[i]);
			}
		}
		
		int k = 0;
		for(int i=0;i<n;i++){
			for(int j=0;buckets[i]!=null&&j<buckets[i].size();j++){
				a[k++] = buckets[i].get(j);
			}
		}
	}
	
	public static void main(String[] args) {
		double[] a = {0.78,0.17,0.39,0.26,0.72,0.94,0.21,0.12,0.23,0.68};
		sort(a);
		for (double d : a) {
			System.out.print(d+" ");
		}
		System.out.println();
	}
}
