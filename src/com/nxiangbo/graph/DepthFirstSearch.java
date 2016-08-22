package com.nxiangbo.graph;

public class DepthFirstSearch {
	private boolean[] marked;
	private int count ;
	public DepthFirstSearch(Graph G, int s){
		marked = new boolean[G.V()];
		count = 0;
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		count++;
		for(int w:G.adj(v)){
			if(!marked[w]) dfs(G, w);
		}
	}
	
	public boolean marked(int v){
		return marked[v];
	}
	
	public int count(){
		return count;
	}
}
