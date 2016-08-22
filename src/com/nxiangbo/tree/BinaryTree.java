package com.nxiangbo.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
			left = null;
			right = null;
		}
	}
	
	private static TreeNode root;
	public BinaryTree() {
		root = new TreeNode(0);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
	}
	
	
	public int maxDepth(TreeNode root){
		if(root==null){
			return 0;
		}
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return left>right?left+1:right+1;
	}
	
	/**
	 * Ê±¼ä¸´ÔÓ¶ÈO(N^2)
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root){
		if(root==null){
			return true;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if(Math.abs(left-right)>1){
			return false;
		}
		
		return isBalanced(root.left)&&isBalanced(root.right);
	}
	
	public int checkDepth(TreeNode root){
		if(root==null){
			return 0;
		}
		
		int left = checkDepth(root.left);
		if(left==-1){
			return -1;
		}
		int right = checkDepth(root.right);
		if(right==-1){
			return -1;
		}
		int diff = left-right;
		if(Math.abs(diff)>1){
			return -1;
		} else{
			return left>right?left+1:right+1;
		}
	}
	
	public boolean isBalancedImproved(TreeNode root){
		if(checkDepth(root)==-1){
			return false;
		}else{
			return true;
		}
	}
	public TreeNode sortedArrayToBST(int[] sortedNums){
		return sortedArrayToBST(sortedNums, 0, sortedNums.length-1);
	}
	
	public TreeNode sortedArrayToBST(int[] sortedNums, int low, int high){
		if(low>high){
			return null;
		}
		int mid = (low+high)/2;
		TreeNode tree = new TreeNode(sortedNums[mid]);
		tree.left = sortedArrayToBST(sortedNums, low, mid-1);
		tree.right = sortedArrayToBST(sortedNums, mid+1, high);
		return tree;
	}
	
	public void preorder(TreeNode root){
		if(root!=null){
			System.out.print(root.val+",");
			preorder(root.left);
			preorder(root.right);
			
		}
	}
	
	public boolean isBinarySearchTree(TreeNode root){
		if(root==null) return true;
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean isBinarySearchTree(TreeNode root, int left, int right){
		if(root==null) return true;
		if(root.val<left || root.val>right){
			return false;
		}
		return isBinarySearchTree(root.left, left, root.val) 
				&& isBinarySearchTree(root.right, root.val, right);
	}
	
	public static boolean containsTree(TreeNode root1, TreeNode root2){
		if(root2==null) return true;
		return subTree(root1, root2);
	}
	
	public static boolean subTree(TreeNode root1, TreeNode root2){
		if(root1==null){
			return false;
		}
		if(root1.val==root2.val){
			if(isIdentical(root1, root2)){
				return true;
			}
		}
		
		return subTree(root1.left, root2) || subTree(root2.right, root2);
	}
	public static boolean isIdentical(TreeNode root1, TreeNode root2){
		if(root1==null && root2==null) return true;
		if(root1==null || root2==null) return false;
		if(root1.val!=root2.val){
			return false;
		} else{
			return isIdentical(root1.left, root2.left) 
					&& isIdentical(root1.right, root2.right);
		}
	}
	
	public List<List<TreeNode>> createLevelLinkedListWithBFS(TreeNode root){
		LinkedList<TreeNode> current = new LinkedList<>();
		List<List<TreeNode>> result = new ArrayList<>();
		if(root==null){
			return null;
		}
		current.add(root);
		while(current.size()>0){
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<>();
			for(TreeNode parent:parents){
				if(parent.left!=null){
					current.add(parent.left);
				}
				if(parent.right!=null){
					current.add(parent.right);
				}
			}
			
		}
		
		return result;
		
	}
	
	public List<LinkedList<TreeNode>> createLevelLinkedListWithDFS(TreeNode root){
		List<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedListWithDFS(root, result, 0);
		return result;
	}
	
	public void createLevelLinkedListWithDFS(TreeNode root, 
			List<LinkedList<TreeNode>> lists, int level){
		if(root==null) return ;
		LinkedList<TreeNode> list = new LinkedList<>();
		if(list.size()==level){
			lists.add(list);
		}else{
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedListWithDFS(root.left, lists, level+1);
		createLevelLinkedListWithDFS(root.right, lists, level+1);
	}
	
	public TreeNode findFirstCommonAncessor(TreeNode root, TreeNode p, TreeNode q){
		if(root==null) return null;
		if(root==p || root == q){
			return root;
		}
		TreeNode left = findFirstCommonAncessor(root.left, p, q);
		TreeNode right = findFirstCommonAncessor(root.right, p, q);
		if(left!=null && right!=null){
			return root;
		} else{
			return left==null?right:left;
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		System.out.println(tree.maxDepth(root));
		System.out.println(tree.isBalanced(root));
		System.out.println(tree.checkDepth(root));
		System.out.println(tree.isBalancedImproved(root));
		int[] sortedNums = {1,2,3,4,5,6};
		BinaryTree bst = new BinaryTree();
		TreeNode bstRoot = bst.sortedArrayToBST(sortedNums);
		bst.preorder(bstRoot);
		System.out.println(bst.isBinarySearchTree(bstRoot));
		
		int[] sortedNums2 = {1,2,3,4,5};
		BinaryTree bst2 = new BinaryTree();
		TreeNode bstRoot2 = bst2.sortedArrayToBST(sortedNums2);
		System.out.println(isIdentical(bstRoot,bstRoot2));
		
	}
}
