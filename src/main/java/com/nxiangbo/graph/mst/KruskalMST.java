package com.nxiangbo.graph.mst;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

import com.nxiangbo.graph.unionfind.UF;

public class KruskalMST {
	private ArrayDeque<Edge> mst;
	public KruskalMST(EdgeWeightedGraph G){
		mst = new ArrayDeque<>();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		for(Edge e:G.edges()){
			pq.offer(e);
		}
		UF uf = new UF(G.V());
		
		while(!pq.isEmpty()&&mst.size()<G.V()-1){
			Edge e = pq.poll();
			int v = e.either();
			int w = e.other(v);
			if(uf.connected(v, w)){
				continue;
			}
			uf.union(v, w);
			mst.offer(e);
		}
		
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
	public double weight(){
		double weight = 0.0;
		for (Edge edge : mst) {
			weight += edge.weight();
		}
		return weight;
	}
}
