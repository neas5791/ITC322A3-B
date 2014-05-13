package edu.colorado.graphs;

import java.util.Set;


public class Dijkstra extends Graph{

	private int [][] weight;
	private int [] distance;
	private int [] precede;
	
	
	public Dijkstra(int n) {
		super(n);
		distance = new int[n];
		precede = new int [n];
		weight = new int [n][n];
	}
	
	public Dijkstra(Graph g){
		this(g.size());
		this.edges = g.edges;
		this.labels = g.labels;
		//distance = new int[g.size()];
		initialize();
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
		while (current != destination-1) {
			int currentDistance = distance[current];
			int smallestDistance = Integer.MAX_VALUE;		// starts tracking the smallest distance
			int k = -1;										// marker for keeping track of the smallest distance
			
			//set current vertices to visited 
			visited[current] = true;
			
			for (int i = 0; i < n; i++){
				if (visited[i])
					continue;
				int newDistance;
				if (weight[current][i] != Integer.MAX_VALUE)
					newDistance = currentDistance + weight [current][i];
				else
					newDistance = Integer.MAX_VALUE;
				
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
		
		//Set<Integer> allowedVerticies;
	}
	
	public void initialize(){
		
		// setup the weight array so when an edge exists it has a weight of 1
		for (int i = 0; i < super.size(); i++)
			for (int j = 0; j < super.size(); j++){
				if (edges[i][j])
					weight[i][j] = 1;
				else
					weight[i][j] = Integer.MAX_VALUE;
			}
	}
	
	public void printPathV1(){
		for (int i = 0; i < super.size(); i++) {
			System.out.println(this.labels[i]);
		}
		System.out.println("The distance between " + this.labels[0] + " and " + this.labels[super.size()] + " is " + distance[super.size()]);
	}
	
	/**
     * Get the shortest path across a tree that has had its path weights
     * calculated.
     */
    public int[] getShortestPath(int source, int destination) {
		int i = destination;
		int finall = 0;
		int[] path = new int[super.size()];
	 
		path[finall] = destination;
		finall++;

		while (precede[i] != source) {
		    i = precede[i];
		    path[finall] = i;
		    finall++;
		}
		
		path[finall] = source;
	 
		int[] result = new int[finall+1];
		System.arraycopy(path, 0, result, 0, finall+1);
		return result;
    }
 
    /**
     * Print the result.
     */
    public void displayResult(int[] path) {
		System.out.println("\nThe shortest path followed is : \n");
		int cost = 0;
		for (int i = path.length-1 ; i>0 ; i--){
			System.out.printf("\t\t( %8d\t-> %5d  ) with cost = %d\n", path[i], path[i-1], weight[path[i]][path[i-1]]);
			cost += weight[path[i]][path[i-1]];
		    //System.out.println("\t\t( " + path[i] + " ->" + path[i-1] + " ) with cost = " + weight[path[i]][path[i-1]]);
		}
		System.out.println("For the Total Cost = " + cost);// distance[path[path.length-1]]);
    }
}