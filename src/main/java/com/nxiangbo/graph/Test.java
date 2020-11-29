package com.nxiangbo.graph;

public class Test {
	public static void main(String[] args) {
		Graph graph = new Graph(10);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(5, 3);
		graph.addEdge(3, 4);
		DepthFirstSearch search = new DepthFirstSearch(graph, 0);
		int count = search.count();
		System.out.println(count);
		
		boolean marked = search.marked(1);
		System.out.println(marked);
		
		DepthFirstPath path = new DepthFirstPath(graph, 0);
		Iterable<Integer> traces = path.pathTo(3);
		System.out.println(traces.toString());
		
		BreadthFirstPath bPath = new BreadthFirstPath(graph, 0);
		Iterable<Integer> bTraces = bPath.pathTo(4);
		System.out.println(bTraces.toString());
		
		graph.addEdge(6, 7);
		graph.addEdge(8, 9);
		CC cc = new CC(graph);
		boolean isconnected = cc.connected(2, 9);
		System.out.println(isconnected);
		System.out.println(cc.count());
		
		
		Cycle c = new Cycle(graph);
		boolean hasCycle = c.hasCycle();
		System.out.println(hasCycle);
		
		TwoColor tc = new TwoColor(graph);
		boolean isTwoColor = tc.isTwoColorable();
		System.out.println(isTwoColor);
	}
}
