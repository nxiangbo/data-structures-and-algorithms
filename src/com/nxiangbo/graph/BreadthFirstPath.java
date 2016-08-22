package com.nxiangbo.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//bfs可以用于求解单源最短路径
public class BreadthFirstPath {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	public BreadthFirstPath(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}
	
	private void bfs(Graph G, int s){
		Deque<Integer> queue = new ArrayDeque<>();
		
		queue.offer(s);
		while(!queue.isEmpty()){
			int v = queue.poll();
			for(int w:G.adj(v)){
				if(!marked[w]){
					marked[w] = true;
					edgeTo[w] = v;
					queue.offer(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!marked[v]) return null;
		
		LinkedList<Integer> stack = new LinkedList<>();
		for(int x=v;x!=s;x=edgeTo[x]){
			stack.push(x);
		}
		stack.push(s);
		return stack;
	}
}
