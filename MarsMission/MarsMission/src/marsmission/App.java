package marsmission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
	
	public String displayCompass() {
		System.out.println("\n" + "  N  ");
     	System.out.println("  |  ");
     	System.out.println("W---S");
     	System.out.println("  |  ");
     	System.out.println("  S  " + "\n");
		return null;
	}

	public static void main(String[] args) {
		// Args to insert a file
		String fileName = args[0]; 
		List<String> outputs = new ArrayList<>();
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { //"./src/input.txt" fileName
            String line;
            while ((line = br.readLine()) != null) { // Read the file line per line
                lines.add(line);
            }

            if (lines.isEmpty()) throw new IOException("Le fichier est vide");

            // Read the dimension of the grid
            String[] dimensions = lines.get(0).split(" ");
            int gridX = Integer.parseInt(dimensions[0]) ; //+ 1 add +1 to obtain a grid from 0 to 5
            int gridY = Integer.parseInt(dimensions[1]) ; //+ 1 add +1 to obtain a grid from 0 to 5
            Board marsGrid = new Board(gridX, gridY);

            // Read position of the rover start at position 1 and each 2 lines
            for (int i = 1; i < lines.size(); i += 2) {
                try {
                    String[] parts = lines.get(i).split(" ");
                    int roverX = Integer.parseInt(parts[0]);
                    int roverY = Integer.parseInt(parts[1]);
                    Direction roverDirection = Direction.valueOf(parts[2]);
                    
                    roverDirection.displayCompass();
                  
                    Rover rover = new Rover(roverX, roverY, roverDirection, marsGrid);

                    // At the current i position (rover), the next line gives access to the rover command. 
                    String movements = lines.get(i + 1);

                    // Rover execute move commands (L, R, M)
		        	rover.moveOnGrid(movements);
		        	
		        	// Display the final position
		            System.out.println("Final position - " + rover.getVehiculePosition()); 

		            // Add rover last position to a list contains all the output position of the rovers
                    outputs.add(rover.getVehiculePosition());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            // Display the list of output contains all last rovers position
            System.out.println("\n----------OUTPUTS----------");
	    	for (String rover : outputs) {
				System.out.println(rover);
			}        
	    } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
