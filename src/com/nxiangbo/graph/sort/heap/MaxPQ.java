package com.nxiangbo.graph.sort.heap;

public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq; //基于堆得完全二叉树存储于pq[1...n]中，pq[0]没有使用
	private int N = 0;
	public MaxPQ(int maxN){
		pq = (Key[]) new Comparable[maxN+1];
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public int size(){
		return N;
	}
	
	public void insert(Key v){
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax(){
		Key max = pq[1];
		swap(1, N--);
		sink(1);
		return max;
	}
	
	public void swap(int i, int j){
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
	
	public boolean less(int i, int j){
		return pq[i].compareTo(pq[j])<0;
	}
	
	public void swim(int k){
		while(k>1&&less(k/2, k)){
			swap(k/2, k);
			k = k/2;
		}
	}
	
	public void sink(int k){
		while(2*k<N){
			int j = 2*k;
			if(j<N && less(j,j+1)){
				j++;
			}
			if(less(k,j)){
				swap(k, j);
				k = j;
			} else{
				break;
			}
		}
	}
}
