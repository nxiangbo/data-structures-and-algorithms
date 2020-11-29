package com.nxiangbo.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private final int V;
	private int E;
	private List<Integer>[] adj;
	public Graph(int V){
		this.V = V;
		this.E = 0;
		adj = new List[V];
		for(int i=0;i<V;i++){
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public void addEdge(int v1, int v2){
		adj[v1].add(v2);
		adj[v2].add(v1);
		E++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
//	public String toString(){
//		
//	}
	
}
