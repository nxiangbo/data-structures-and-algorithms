package com.nxiangbo.graph.mst;

import java.util.ArrayList;

public class EdgeWeightedGraph {
	private final int V;
	private int E;
	private ArrayList<Edge>[] adj;
	
	public EdgeWeightedGraph(int V){
		this.V = V;
		this.E = 0;
		adj = new ArrayList[V];
		for(int v = 0;v<V;v++){
			adj[v] = new ArrayList<>();
		}
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public void addEdge(Edge e){
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	
	public Iterable<Edge> edges(){
		ArrayList<Edge> b = new ArrayList<>();
		for(int v=0;v<V;v++){
			for(Edge e:adj[v]){
				if(e.other(v)>v){
					b.add(e);
				}
			}
		}
		return b;
	}
}
