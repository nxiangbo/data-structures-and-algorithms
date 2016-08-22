package com.nxiangbo.search;

import java.util.ArrayDeque;

public class SeparateChainingHashST<Key, Value> {
	private static final int DEFALUT_CAPACITY = 4;
	
	private int n;
	private int m;
	private SequentialSearchST<Key, Value>[] st;
	
	public SeparateChainingHashST(){
		this(DEFALUT_CAPACITY);
	}
	
	public SeparateChainingHashST(int m) {
		this.m = m;
		st = new SequentialSearchST[m];
		for(int i=0;i<m;i++){
			st[i] = new SequentialSearchST<>();
		}
	}
	
	private void resize(int chains){
		SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<>(chains);
		for(int i=0;i<m;i++){
			for(Key key:st[i].keys()){
				temp.put(key, st[i].get(key));
			}
		}
		this.m = temp.m;
		this.n = temp.n;
		this.st = temp.st;
	}
	
	private int hash(Key key){
		return (key.hashCode()&0x7fffffff)%m;
	}
	
	public int size(){
		return n;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public void put(Key key, Value value){
		if(key==null){
			throw new NullPointerException("first argument to put() is null");
		}
		if(value==null){
			delete(key);
			return;
		}
		
		if(n>=10*m){
			resize(2*m);
		}
		
		int i = hash(key);
		if(!st[i].contains(key)) n++;
		st[i].put(key, value);
	}
	
	public Value get(Key key){
		if(key==null){
			throw new NullPointerException("the argument to get() is null");
		}
		int i= hash(key);
		return st[i].get(key);
	}
	
	public boolean contains(Key key){
		if(key==null){
			throw new NullPointerException("the argument to contains() is null");
		}
		return get(key)!=null;
	}
	
	public void delete(Key key){
		if(key==null){
			throw new NullPointerException("the argument to delete() is null");
		}
		int i = hash(key);
		if(st[i].contains(key)) n--;
		st[i].delete(key);
		
		if(m>DEFALUT_CAPACITY&&n<=2*m) resize(m/2);
	}
	
	public Iterable<Key> keys(){
		ArrayDeque<Key> queue = new ArrayDeque<>();
		for(int i=0;i<m;i++){
			for(Key key:st[i].keys()){
				queue.offer(key);
			}
		}
		return queue;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++){
			sb.append(st[i].toString()+" ");
		}
		return sb.toString();
	}
}
