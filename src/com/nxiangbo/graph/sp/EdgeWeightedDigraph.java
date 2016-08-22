package com.nxiangbo.graph.sp;

import java.util.ArrayList;

public class EdgeWeightedDigraph {
	private final int V;
	private int E;
	private ArrayList<DirectedEdge>[] adj;
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedDigraph(int V){
		this.V = V;
		this.E = 0;
		adj = new ArrayList[V];
		for(int i=0;i<V;i++){
			adj[i] = new ArrayList<>();
		}
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public void addEdge(DirectedEdge e){
		adj[e.from()].add(e);
		E++;
	}
	
	public Iterable<DirectedEdge> adj(int v){
		return adj[v];
	}
	
	public Iterable<DirectedEdge> edges(){
		ArrayList<DirectedEdge> edges = new ArrayList<>();
		for(int i=0;i<V;i++){
			for(DirectedEdge e:adj[i]){
				edges.add(e);
			}
		}
		return edges;
	}
}
