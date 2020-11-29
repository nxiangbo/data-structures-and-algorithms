package com.nxiangbo.graph;

public class Cycle {
	private boolean[] marked;
	private boolean hasCycle;
	
	public Cycle(Graph G){
		marked = new boolean[G.V()];
		hasCycle = false;
		for(int s=0;s<G.V();s++){
			dfs(G, s, s);
		}
	}
	
	private void dfs(Graph G, int s, int v){
		marked[s] = true;
		for(int w:G.adj(s)){
			if(!marked[w]){
				dfs(G, w, s);
			} else if(w!=s){
				hasCycle = true;
			}
		}
	}
	
	public boolean hasCycle(){
		return hasCycle;
	}
}
