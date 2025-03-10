package marsmission;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private final int width;
    private final int height;
    private final String[][] grid;
    private List<Vehicle> listVehicle = new ArrayList<>();

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new String[width+1][height+1]; // Add +1 to obtain a grid from 0 to 5
        initializeGrid(); // Initialize the grid with coordinate 
    }

    private void initializeGrid() {
    	// Display the board with coordinate 0,0 on the lower-left corner
        for (int y = height; y >= 0; y--) { // With the grid (0,4) : height - 1
            for (int x = 0; x <= width; x++) { // With the grid (0,4) : < width
                grid[x][y] = x + " " + y;
            }
        }
    }

    // Check if the position x,y is a valid on the grid
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x <= width && y >= 0 && y <= height; // With the grid (0,4) : x >= 0 && x < width && y >= 0 && y < height;
    }

    public void clearCell(int x, int y) {
        grid[x][y] = x + " " + y;
    }
    
    // Display the grid with the position of the vehicule
    public void printGrid() {
        // Place vehicle on the board
        for (Vehicle vehicle : this.listVehicle) {
            int x = vehicle.position.getX();
            int y = vehicle.position.getY();
            // Replace with direction symbol
            this.grid[x][y] = vehicle.getDirection().getSymbol(); 
        }

        // Display the board with coordinate 0,0 on the lower-left corner
        for (int y = height ; y >= 0; y--) { // Before for 0,4 : height - 1
            for (int x = 0; x <= width; x++) { // Before for 0,4 : < width
                System.out.print(this.grid[x][y] + " | ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    // Add vehicle to vehicle list
    public void addVehicle(Vehicle vehicle) {
    	this.listVehicle.add(vehicle);
    }
    
    // Check if cell position is occupied by a vehicle position
    public boolean cellIsOccupied(Position position) {
    	for (Vehicle vehicle : this.listVehicle) {
    		if (vehicle.getPosition().isEqual(position)) {
    			System.out.println("There is a rover in this position");
				return true;
			}
		}
		return false;
    }

	public String[][] getGrid() {
		return grid;
	}
    
    
}
