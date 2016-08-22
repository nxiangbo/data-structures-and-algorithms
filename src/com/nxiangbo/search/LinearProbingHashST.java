package com.nxiangbo.search;

public class LinearProbingHashST<Key, Value> {
	private static final int DEFAULT_CAPACITY = 4;
	
	private int n;
	private int m;
	private Key[] keys;
	private Value[] values;
	
	public LinearProbingHashST(){
		this(DEFAULT_CAPACITY);
	}
	
	public LinearProbingHashST(int capacity){
		m = capacity;
		n = 0;
		keys = (Key[]) new Object[m];
		values = (Value[]) new Object[m];
		
	}
	
	private int hash(Key key){
		return (key.hashCode()&0x7fffffff)%m;
	}
	
	private void resize(int capacity){
		LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<>(capacity);
		for(int i=0;i<m;i++){
			if(keys[i]!=null){
				temp.put(keys[i], values[i]);
			}
		}
		keys = temp.keys;
		values = temp.values;
		m = temp.m;
	}
	
	public void put(Key key, Value value){
		if(key==null){
			throw new NullPointerException("the argument to put() is null");
		}
		if(value==null){
			delete(key);
			return;
		}
		if(n>=m/2) resize(2*m);
		int i = hash(key);
		for(;keys[i]!=null;i=(i+1)%m){
			if(keys[i].equals(key)){
				values[i] = value;
				return;
			}
		}
		keys[i] = key;
		values[i] = value;
		n++;
	}
	
	public Value get(Key key){
		if(key==null) {
			throw new NullPointerException("the argument to get() is null");
		}
		for(int i=hash(key);keys[i]!=null;i=(i+1)%m){
			if(keys[i].equals(key)){
				return values[i];
			}
		}
		return null;
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
		if(!contains(key)) return;
		
		int i  = hash(key);
		while(!key.equals(keys[i])){
			i = (i+1)%m;
		}
		keys[i] = null;
		values[i] = null;
		
		i = (i+1)%m;
		while(keys[i]!=null){
			Key keyToRehash = keys[i];
			Value valueToRehash = values[i];
			keys[i] = null;
			values[i] = null;
			n--;
			put(keyToRehash, valueToRehash);
			i = (i+1)%m;
		}
		n--;
		
		if(n>0&&n<=8/m) resize(m/2);
		
		assert check();
	}
	
	private boolean check(){
		if(m<2*n){
			System.err.println("Hash Table size m="+m+"; array size n = "+n);
			return false;
		}
		for(int i=0;i<m;i++){
			if(keys[i]==null)continue;
			else if(get(keys[i])!=values[i]){
				System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + values[i]);
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++){
			if(keys[i]!=null){
				sb.append(keys[i]+" - "+values[i]+" ");
			}
		}
		return sb.toString();
	}
	
}
