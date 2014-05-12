import java.util.Scanner;


public class Driver {
	
	public static Scanner scanner = new Scanner(System.in);
	private static Maze m;
	private static String name;
	
	public static void main (String [] args){
		//Maze m;
		boolean quit = false;
		int menu;
		do{
			if (m == null)
				System.out.println("Welcome to the Maze Driver by Sean Matkovich #11187033\n"
							+ "========================================================");
			else
				System.out.println("File " + name + " loaded\n"
						+ "==================================");
				
			System.out.print("This program will demonstrate the implemented features of the Maze Class.\n"
							+ "\nSelect from the following menu by entering menu number at the prompt."
							+ "\n1. Load Maze a file."
							+ "\n2. Display Maze"
							+ "\n3. Find path using Depth-First-Search"
							+ "\n4. "
							+ "\n5. "
							+ "\n6. "
							+ "\n7. "
							+ "\n8. Quit."
							+ "\nMake your selection: ");
			menu = scanner.nextInt();

			switch (menu){
			case 1:
				loadMazeMenu();
				break;
			case 2:
				if (m != null)
					System.out.println(m.toString());
				break;
			case 3:
				if (m != null) {
					boolean[] visited = new boolean[m.g.size()];
					m.DepthFirstSolution(0, visited);
					
					System.out.println("The vertex path is as follows; ");
					m.printPath();
					m.updateMazeWithPath();
					System.out.println(m.toString());
				}
				break;
			case 4:

			case 5:

			case 6:

			case 7:

			default:
				quit = !quit;
				System.out.println("See you later :) hope you had fun!!");
				break;
			}
		}while (!quit);
	}
	
	private static void loadMazeMenu(){
		boolean quit = false;
		int menu;
		do{
			System.out.println("\nLOAD MAZE FILE; \n"
								+ "===============\n");
				
			System.out.print("\nSelect from the following menu by entering menu number at the prompt."
							+ "\n1. Load \"maze01.mz\" file."
							+ "\n2. Load \"maze02.mz\" file."
							+ "\n3. Load \"maze03.mz\" file."
							+ "\n4. back to main menu."
							+ "\nMake your selection: ");
			menu = scanner.nextInt();
						
			switch (menu){
			case 1:
				name = "maze01.mz";
				m = new Maze(name);
				quit = !quit;
				break;
			case 2:
				name = "maze02.mz";
				m = new Maze(name);
				quit = !quit;
				break;
			case 3:
				name = "maze03.mz";
				m = new Maze(name);
				quit = !quit;
				break;
			default:
				quit = !quit;
				System.out.println("Back to main menu");
				break;
			}
		}while (!quit);
		
		
	}
}
