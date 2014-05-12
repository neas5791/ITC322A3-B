package edu.colorado.graphs;

import java.util.Set;


public class Dijkstra extends Graph{

	private int [] distance;
	
	public Dijkstra(int n) {
		super(n);
		distance = new int[super.size()];
	}
	
	public Dijkstra(Graph g){
		super();
		this.edges = g.edges;
		this.labels = g.labels;
		distance = new int[g.size()];
	}

	public void ShortestPath(){
		
		for (int i = 0; i < distance.length; i++){
			if (i == 0)
				distance[i] = 0;
			else
				distance[i] = -1;
		}
		System.out.println("The distance array length is " + distance.length);
		System.out.println(distance[0]);
		System.out.println(distance[5]);
		
		Set<Integer> allowedVerticies;
	}
	
}
