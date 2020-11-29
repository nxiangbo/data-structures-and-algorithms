package com.nxiangbo.search;

import java.util.ArrayDeque;

public class SequentialSearchST<Key, Value> {
	private int n;
	private Node head;
	
	class Node{
		private Key key;
		private Value value;
		private Node next;
		public Node(Key key, Value value, Node next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public Key getKey(){
			return key;
		}
		
		public Value getValue(){
			return value;
		}
	}
	
	public int size(){
		return n;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public void put(Key key, Value value){
		if(key==null){
			throw new NullPointerException("key can not be null");
		}
		
		if(value==null){
			delete(key);
			return;
		}
		
		for(Node x = head;x!=null;x=x.next){
			if(key.equals(x.key)){
				x.value = value;
				return ;
			}
		}
		
		head = new Node(key, value, head);
		n++;
	}
	
	public Value get(Key key){
		if(key==null){
			throw new NullPointerException("key can not be null");
		}
		for(Node x = head;x!=null;x=x.next){
			if(key.equals(x.key)){
				return x.value;
			}
		}
		return null;
	}
	
	public boolean contains(Key key){
		if(key==null){
			throw new NullPointerException("key can not be null");
		}
		return get(key)!=null;
	}
	
	public void delete(Key key){
		if(key==null){
			throw new NullPointerException("the argument of delete() is null");
		}
		head = delete(head, key);
	}
	
	private Node delete(Node node, Key key){
		if(node==null){
			return null;
		}
		if(key.equals(node.key)){
			n--;
			return node.next;
		}
		node.next = delete(node.next, key);
		return node;
		
	}
	
	public Iterable<Key> keys(){
		ArrayDeque<Key> queue = new ArrayDeque<>();
		for(Node x=head;x!=null;x=x.next){
			queue.offer(x.key);
		}
		
		return queue;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Node x=head;x!=null;x=x.next){
			sb.append(x.key+" - "+x.value+" ");
		}
		sb.append("]");
		return sb.toString();
	}
	
}
