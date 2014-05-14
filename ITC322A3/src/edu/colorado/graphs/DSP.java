package edu.colorado.graphs;

public class DSP {

	private Graph g;
	private int n;
	private int[][] weight;
	private int[] distance;
	private int[] precede;
	
	
	public DSP(Graph g) {
		this.g = g;
		this.n = g.size();
		this.weight = constructWeightArray();
		this.distance = new int[n];
		this.precede = new int [n];

	}
	
	public void buildSpanningTree(int source, int destination){
		boolean [] visited = new boolean[n];
		int current = source;
		
		
		
		for (int i = 0; i < n; i++){
			distance[i] = Integer.MAX_VALUE;
			precede[i] = 0;
		}
		distance[source] = 0;
		
		// Begin iterating through the tree
		while ( current != destination){
			
			if (current == 6) {
				System.out.println("SIX");
			}
			
			
			// Array of vertices connected to current vertex
			int[] neighbor = g.neighbors(current);
			int closestNeighbor = -1;
			int smallestDistance = Integer.MAX_VALUE;
			
			// Set current/source cell to visited
			visited[current] = true;

					
			for (int i = 0; i < neighbor.length; i++){
				int testVertex = neighbor[i]; // the vertex to check

				// check if the neighboring vertex has already been visited
				if(visited[testVertex])
					continue;
				int newDistance;
				// newDistncae is the current distance plus the weight the neighbor
				if (distance[current] == Integer.MAX_VALUE)
					newDistance = weight[current][testVertex];
				else
					newDistance = distance[current] + weight[current][testVertex];
				
				if ( newDistance < distance[testVertex] ){
					distance[testVertex] = newDistance;
					precede[testVertex] = current;
				}
				
				if (distance[i] < smallestDistance ){
					smallestDistance = distance[testVertex];
					closestNeighbor = testVertex;
				}
				

			}
			
			if (closestNeighbor == -1){
				//for (int j = 0; j < visited.length; j ++)
					//if (!visited[j]){
						closestNeighbor = precede[current];
						//break;
					//}
			}
			current = closestNeighbor;
		}
		for (int i = 0; i < distance.length; i++)
			if (distance[i] != Integer.MAX_VALUE)
				System.out.println("Vertex " + i + " is a distance " + distance[i]);
	}

	private int [][] constructWeightArray(){
		
		this.weight = new int [n][n];
		
		// Iterate through the Graphs edges array and 
		// construct the weight array
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				if(g.edges[i][j])
					weight[i][j] = 1;
				else
					weight[i][j] = 0;
			}
		}
		
		return weight;
	}
}
