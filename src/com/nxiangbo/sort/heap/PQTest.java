package com.nxiangbo.sort.heap;

public class PQTest {
	public static void main(String[] args) {
		int[] nums = {2,5,6,1,34};
		MaxPQ<Integer> pq = new MaxPQ<>(nums.length);
		for(int i=0;i<nums.length;i++){
			pq.insert(nums[i]);
		}
		
		System.out.println(pq.delMax());
		System.out.println(pq.delMax());
	}
}
