package marsmission;

public class Rover extends Vehicle{

	private static int idRoverCounter = 0;

    public Rover(int x, int y, Direction direction, Board board) {
        super(x, y, direction, board);
        this.idVehicle = ++idRoverCounter;
    }

    // Rover turn left
    @Override
    public void rotateLeft() throws Exception {
    	switch (direction) {
	        case N:
	            direction = Direction.W;
	            break;
	        case W:
	            direction = Direction.S;
	            break;
	        case S:
	            direction = Direction.E;
	            break;
	        case E:
	            direction = Direction.N;
	            break;
	        default:
	        	//System.out.println("Direction unknown : " + direction);
	        	throw new Exception("Direction unknown : " + direction);
    	}
    }

    // Rover turn right
    @Override
    public void rotateRight() throws Exception {
    	switch (direction) {
	        case N:
	            direction = Direction.E;
	            break;
	        case E:
	            direction = Direction.S;
	            break;
	        case S:
	            direction = Direction.W;
	            break;
	        case W:
	            direction = Direction.N;
	            break;
	        default:
	        	//System.out.println("Direction unknown : " + direction);
	        	throw new Exception("Direction unknown : " + direction);
    	}
    }

    // Rover move forward with his actual direction
    @Override
    public void moveForward() throws Exception {
        int newX = position.getX();
        int newY = position.getY();

        switch (direction) {
	        case N:
	            newY++;
	            break;
	        case E:
	            newX++;
	            break;
	        case S:
	            newY--;
	            break;
	        case W:
	            newX--;
	            break;
	        default:
	        	//System.out.println("Direction unknown : " + direction);
	            throw new Exception("Direction unknown : " + direction);
        }

        // Check if position is valid and cell is unoccupied in order to set the new position of the rover
        if (board.isValidPosition(newX, newY) && !board.cellIsOccupied(new Position(newX, newY))) {
        	// Reset and clear the cell and set the position of the rover with the new coordinates 
            this.board.clearCell(this.position.getX(), this.position.getY()); 
            this.position.setX(newX);
            this.position.setY(newY);
        } else {
            throw new Exception("Invalid position (out of the grid) or the cell is occupied ");
        }
    }
    
    // Rover move on the grid by executing commands L (turnleft) R (turnright) M (moveforward)
    @Override
	public void moveOnGrid(String movements) throws Exception {
    	for (char movement : movements.toCharArray()) {
            switch (movement) {
                case 'L':
                    rotateLeft();
                    break;
                case 'R':
                    rotateRight();
                    break;
                case 'M':
                	try {
                        moveForward();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                	System.out.println("Command unknown : " + movement); 
                    //throw new Exception("Command unknown");
            }
            // After each movements display the grid
            this.board.printGrid();
        }
		
	}
}
