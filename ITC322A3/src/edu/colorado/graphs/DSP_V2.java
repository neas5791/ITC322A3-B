package edu.colorado.graphs;

import java.util.LinkedList;
import java.util.Queue;


public class DSP_V2 extends Graph {

	private int n;
	private int[][] weight;
	private int[] distance;
	private int[] precede;
	@SuppressWarnings("unused")
	private int[] shortestPath;
	
	public DSP_V2(int n){
		super(n);
		this.n = size();
		this.weight = constructWeightArray();
		this.distance = new int[n];
		this.precede = new int [n];
	}
	
	public DSP_V2(Graph g) {
		this.edges = g.edges;
		this.labels = g.labels;
		
		this.n = size();
		this.weight = constructWeightArray();
		this.distance = new int[n];
		this.precede = new int [n];

	}
	
	public void buildSpanningTree(int source, int destination){
		boolean [] visited = new boolean[n];
		//boolean [] allowed = new boolean[n];
		Queue<Integer> allowed = new LinkedList<Integer>();
		
		int current = source;
		
		for (int i = 0; i < n; i++){
			distance[i] = Integer.MAX_VALUE;
			precede[i] = 0;
		}
		distance[source] = 0;
		// Set current/source cell to visited
		
		// Begin iterating through the tree
		while ( current != destination){
			visited[current] = true;
	
			// Array of vertices connected to current vertex
			int[] neighbor = neighbors(current);
			int nextNeighbor = -1;
			
			for (int i = 0; i < neighbor.length; i++)
				if (!visited[neighbor[i]])
					allowed.add(neighbor[i]);
					
			for (int i = 0; i < neighbor.length; i++){
				
				// this is the neighboring vertex we will be checking
				int testVertex = neighbor[i]; 
				
				// check if the neighboring vertex has already been visited
				if(visited[testVertex]){
					allowed.remove(testVertex);
					continue;
				}
				
				// newDistance is the current distance plus the weight the neighbor
				int newDistance;
				// catches overflow problem... because the vertex is neighboring we 
				// know there will be weight information
				if (distance[current] == -1)
					newDistance = weight[current][testVertex];
				else
					newDistance = distance[current] + weight[current][testVertex];
				
				// check if the value calculated by newDistance is shorter than existing data
				// if it is a shorter distance then the distance a current vertex data is 
				// set in the distance array information 
				if (newDistance < distance[testVertex] ){
					distance[testVertex] = newDistance;
					precede[testVertex] = current;
				}
			}
			
			// The thinking part of the implementation...
			// 
			int min = Integer.MAX_VALUE;
			//if (nextNeighbor == -1){
				for (int vertex : allowed){
					if (distance[vertex] < min)
						min = distance[vertex];
						nextNeighbor = vertex;
				}
				allowed.remove(nextNeighbor);
				current = nextNeighbor;
			//}
			//else {
			//	allowed.remove(nextNeighbor);
			//	current = nextNeighbor;
			//}
		}
		
		this.shortestPath = getShortestPath(source, destination);
	}

	public void printDistance(){
		
		for (int i = 0; i < distance.length; i++)
			if (distance[i] != Integer.MAX_VALUE)
				System.out.printf("Vertex %4d is a distance %4d\n" , i , distance[i]);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private int [][] constructWeightArray(){
		
		this.weight = new int [n][n];
		
		// Iterate through the Graphs edges array and 
		// construct the weight array
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				if(this.edges[i][j])
					weight[i][j] = 1;
				else
					weight[i][j] = 0;
			}
		}
		
		return weight;
	}

	
	
	// *** this works yayyyyy
    public int[] getShortestPath(int source, int destination) {
		int i = destination;
		int finall = 0;
		int[] path = new int[n];
	 
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
			System.out.printf("\t\t( %4d\t-> %5d  ) with cost = %d\n", path[i], path[i-1], weight[path[i]][path[i-1]]);
			cost += weight[path[i]][path[i-1]];
		    //System.out.println("\t\t( " + path[i] + " ->" + path[i-1] + " ) with cost = " + weight[path[i]][path[i-1]]);
		}
		System.out.println("For the Total Cost = " + cost);// distance[path[path.length-1]]);
	}
	

}
