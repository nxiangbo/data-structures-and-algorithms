package com.nxiangbo.graph.mst;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LazyPrimMST {
	private boolean[] marked;
	private ArrayDeque<Edge> mst;
	private PriorityQueue<Edge> pq;
	
	public LazyPrimMST(EdgeWeightedGraph G){
		pq = new PriorityQueue<>();
		marked = new boolean[G.V()];
		mst = new ArrayDeque<>();
		
		visit(G, 0);
		
		while(!pq.isEmpty()){
			Edge e = pq.poll();
			
			int v = e.either();
			int w = e.other(v);
			if(marked[v]&&marked[w]) continue;
			mst.offer(e);
			if(!marked[v]) visit(G, v);
			if(!marked[w]) visit(G, w);
		}
		
	}
	
	public void visit(EdgeWeightedGraph G, int v){
		marked[v] = true;
		
		for(Edge e:G.adj(v)){
			if(!marked[e.other(v)]){
				pq.offer(e);
			}
		}
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
	public double weight(){
		double weight = 0.0;
		for (Edge edge : mst) {
			weight +=edge.weight();
		}
		return weight;
	}
	
	
}
