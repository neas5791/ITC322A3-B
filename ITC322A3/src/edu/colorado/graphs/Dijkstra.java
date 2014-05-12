package edu.colorado.graphs;

import java.util.Set;


public class Dijkstra extends Graph{

	private int [][] weight;
	private int [] distance;
	private int [] precede;
	
	
	public Dijkstra(int n) {
		super(n);
		distance = new int[super.size()];
		precede = new int [super.size()];
		weight = new int [n][n];
	}
	
	public Dijkstra(Graph g){
		//super();
		this.edges = g.edges;
		this.labels = g.labels;
		distance = new int[g.size()];
	}

	public void ShortestPath(int source, int destination){
		int n = super.size();
		boolean [] visited = new boolean [n];
		
		// Initialize distance and precede array 
		for (int i = 0; i < n; i++){
			distance[i] = Integer.MAX_VALUE;
			precede[i] = Integer.MAX_VALUE;
		}
		// set distance of source to itself as zero
		distance[source] = 0;
		
		//create a holder
		int current = source;
		while (current != destination) {
			int currentDistance = distance[current];
			int smallestDistance = Integer.MAX_VALUE;		// starts tracking the smallest distance
			int k = -1;										// marker for keeping track of the smallest distance
			
			//set current vertices to visited 
			visited[current] = true;
			
			for (int i = 0; i < n; i++){
				if (visited[current])
					continue;
				
				int newDistance = currentDistance + weight [current][i];
				if (newDistance < distance[i]){
					distance[i] = newDistance;
					precede[i] = current;
				}
				
				if (distance[i] < smallestDistance) {
					smallestDistance = distance[i];
					k = i;
				}
			}
			current = k;			
		}
		
		
		
		
		
		System.out.println("The distance array length is " + distance.length);
		System.out.println(distance[0]);
		System.out.println(distance[5]);
		
		Set<Integer> allowedVerticies;
	}
	
	public void initialize(){
		
		// setup the weight array so when an edge exists it has a weight of 1
		for (int i = 0; i < super.size(); i++)
			for (int j = 0; j < super.size(); j++){
				if (edges[i][j])
					weight[i][j] = 1;
				else
					weight[i][j] = 0;
			}
	}
}