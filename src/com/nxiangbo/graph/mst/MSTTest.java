package com.nxiangbo.graph.mst;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MSTTest {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("tinyEWG"));
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int V = in.nextInt();
			int E = in.nextInt();
			Edge[] edges = new Edge[E];
			for(int i=0;i<E;i++){
				int v = in.nextInt();
				int w = in.nextInt();
				double weight = in.nextDouble();
				edges[i] = new Edge(v, w, weight); 
			}
			
			EdgeWeightedGraph G = new EdgeWeightedGraph(V);
			for(int i=0;i<E;i++){
				G.addEdge(edges[i]);
			}
			
			LazyPrimMST primMst = new LazyPrimMST(G);
			System.out.println("Prime Algorithm:");
			System.out.println(primMst.edges());
			System.out.println(primMst.weight());
			
			KruskalMST kruskalMst = new KruskalMST(G);
			System.out.println("Kruskal Algorithm:");
			System.out.println(kruskalMst.edges());
			System.out.println(kruskalMst.weight());
		}
	}
}
