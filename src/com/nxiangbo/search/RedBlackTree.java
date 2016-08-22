package com.nxiangbo.search;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	private class Node{
		private Key key;
		private Value value;
		private Node left, right;
		private int N;
		private boolean color;
		
		public Node(Key key, Value value, int N, boolean color) {
			this.key = key;
			this.value = value;
			this.N = N;
			this.color = color;
		}
	}
	
	public boolean isRed(Node x){
		if(x==null) return false;
		return x.color==RED;
	}
	
	public int size(){
		return size(root);
	}
	
	public int size(Node node){
		if(node==null) return 0;
		else return node.N;
	}
	
	public Value get(Key key){
		if(key==null ) throw new NullPointerException("key cannot be null");
		return get(root, key);
	}
	
	public Value get(Node node, Key key){
		while(node!=null){
			int cmp = key.compareTo(node.key);
			if(cmp<0) node = node.left;
			else if(cmp>0) node = node.right;
			else return node.value;
//			System.out.println(cmp);
		}
		return null;
	}
	
	public Node rotateLeft(Node h){
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1+size(h.left)+size(h.right);
		return x;
	}
	
	public Node rotateRight(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1+size(h.left)+size(h.right);
		return x;
	}
	
	public void flipColors(Node h){
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	public void put(Key key,Value value){
		root = put(root, key, value);
		root.color = BLACK;
	}
	
	private Node put(Node h, Key key, Value value){
		if(h==null){
			return new Node(key, value, 1, RED);
		}
		int cmp = key.compareTo(h.key);
		if(cmp<0) h.left = put(h.left, key, value);
		else if(cmp>0) h.right = put(h.right, key, value);
		else h.value = value;
		
		if(isRed(h.right)&&isRed(h.left)) h= rotateLeft(h);
		if(isRed(h.left)&& isRed(h.left.left)) h = rotateRight(h);
		if(isRed(h.left) && isRed(h.right)) flipColors(h);
		
		h.N = size(h.left)+size(h.right)+1;
		return h;
	}
	
	public static void main(String[] args) {
		RedBlackTree<Integer, String> rbtree = new RedBlackTree<>();
		rbtree.put(12, "xiaopo");
		rbtree.put(3, "hello");
		rbtree.put(89, "world");
		rbtree.put(13, "how");
		rbtree.put(23, "are");
		rbtree.put(9, "you");
		
		System.out.println(rbtree.get(13));
	}
	
	
}
