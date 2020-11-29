package com.nxiangbo.graph;

import java.util.LinkedList;

public class DepthFirstPath {
	private boolean[] marked;
	// last vertex on known path to this vertex
	private int[] edgeTo;
	private final int s;
	
	public DepthFirstPath(Graph G, int s){
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		for(int w:G.adj(v)){
			if(!marked[w]){
				edgeTo[w]=v;
				dfs(G, w);
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!marked[v]) return null;
		LinkedList<Integer> stack = new LinkedList<>();
		for(int x = v;x!=s;x=edgeTo[x]){
			stack.push(x);
		}
		stack.push(s);
		return stack;
	}
}
