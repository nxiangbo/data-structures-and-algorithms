package com.nxiangbo.tree;

import com.nxiangbo.tree.BinaryTree.TreeNode;

public class FindSum {
	public void findSum(TreeNode node, int sum, int[] path, int level){
		if(node==null) return ;
		path[level] = node.val;
		
		int t = 0;
		for(int i=level;i>=0;i--){
			t+=path[i];
			if(t==sum){
				print(path, i, level);
			}
		}
		
		findSum(node.left, sum, path, level+1);
		findSum(node.right, sum, path, level+1);
		
		path[level] = Integer.MIN_VALUE;
	}
	
	public void findSum(TreeNode node, int sum){
		int depth = depth(node);
		int[] path = new int[depth];
		findSum(node, sum, path, 0);
	}
	
	public int depth(TreeNode node){
		if(node==null){
			return 0;
		}
		
		return Math.max(depth(node.left), depth(node.right))+1;
	}
	
	public void print(int[] path, int low, int high){
		for(int i=low;i<=high;i++){
			System.out.print(path[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] sortedNums = {1,2,3,4,5,6};
		BinaryTree bst = new BinaryTree();
		TreeNode bstRoot = bst.sortedArrayToBST(sortedNums);
		FindSum fs = new FindSum();
		fs.findSum(bstRoot, 6);
	}
}
