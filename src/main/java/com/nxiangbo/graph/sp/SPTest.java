package com.nxiangbo.graph.sp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SPTest {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("tinyEWD"));
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int V = in.nextInt();
			int E = in.nextInt();
			DirectedEdge[] edges = new DirectedEdge[E];
			for(int i=0;i<E;i++){
				int v = in.nextInt();
				int w = in.nextInt();
				double weight = in.nextDouble();
				edges[i] = new DirectedEdge(v, w, weight);
			}
			
			EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
			for(int i=0;i<E;i++){
				G.addEdge(edges[i]);
			}
			
			int s = 0;
			DijkstraSP sp = new DijkstraSP(G, s);
			for(int t=0;t<G.V();t++){
				System.out.print(s+" to "+t);
				System.out.print(String.format("(%4.2f):", sp.distTo(t)));
				if(sp.hasPath(t)){
					for(DirectedEdge e:sp.pathTo(t)){
						System.out.print(e+" ");
					}
				}
				System.out.println();
			}
			
			DijkstraAllPairsSP all = new DijkstraAllPairsSP(G);
			System.out.println("3 to 7:"+all.dist(3, 7));
			System.out.println("0 to 7:"+all.dist(0, 7));
			
		}
	}
}	
