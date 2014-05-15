//import edu.colorado.graphs.DSP;
import edu.colorado.graphs.DSP_V2;



public class test {

	public static void main (String[] args){
		Maze m = new Maze("maze01.mz");
		System.out.println(m.toString());
		
		//DSP d = new DSP(m.g); // this worked!!
		
		DSP_V2 d = new DSP_V2(m.g);
		
		d.buildSpanningTree(0, m.size()-1);
		d.displayResult(d.getShortestPath(0, m.g.size()-1));
		//m.printTable();
		// **m.shortestPath();
		// this actually displays the adjacency Matrix of the graph on the screen 
		// and output a copy to a file
		//m.printTable();
		
		
		// *boolean[] visited = new boolean[m.size()];
		// *m.DepthFirstSolution(0, visited);

		//m.printPath();
		
		// *m.updateMazeWithPath();
//		m.g.depthFirstPrint(m.g, 0);
		
		m.printDepthFirst(0);
		System.out.println(m.toString());
	}
	
}
