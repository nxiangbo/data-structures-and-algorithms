package com.nxiangbo.graph;

public class CC {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public CC(Graph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		count = 0;
		for(int s=0;s<G.V();s++){
			if(!marked[s]){
				dfs(G, s);
				count++;
			}
		}
	}
	
	private void dfs(Graph G, int s){
		marked[s] = true;
		id[s] = count;
		for(int v:G.adj(s)){
			if(!marked[v]){
				dfs(G, v);
			}
		}
	}
	
	public boolean connected(int v1, int v2){
		return id[v1]==id[v2];
	}
	
	public int id(int v){
		return id[v];
	}
	
	public int count(){
		return count;
	}
}
