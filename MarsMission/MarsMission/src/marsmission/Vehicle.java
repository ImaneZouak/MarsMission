package marsmission;

public abstract class Vehicle implements Movement{
	
	protected Position position;
    protected Direction direction;
    protected Board board;
    protected int idVehicle;

    public Vehicle(int x, int y, Direction direction, Board board) {
        this.position = new Position(x, y);
        this.direction = direction;
        this.board = board;
        System.out.println("Initial position - " + "Rover : " + this.getPosition().getX() + " " + this.getPosition().getY() + " " + this.getDirection());
        this.placeVehicle(); // Place the vehicle when vehicle is initialized 
        
    }
    
    // Place the rover on the board and check if the position of the rover is not occupied and 
    // Check if it's inside  the dimension of the grid
    private void placeVehicle() {
    	if (this.board.cellIsOccupied(position)) {
			throw new RuntimeException("Cell is occupied");
		}
    	if (!this.board.isValidPosition(this.position.getX(), this.position.getY())) {
    		throw new RuntimeException("Position doesn't match the dimension of the grid");
		}
    	// Place the vehicle on the board with his direction symbol
        this.board.getGrid()[this.getPosition().getX()][this.getPosition().getY()] = this.getDirection().getSymbol();
        this.board.addVehicle(this);
        this.board.printGrid();
    }

    public Position getPosition() { 
    	return position; 
    }
    
    public Direction getDirection() { 
    	return direction; 
    }
    
    public int getIdVehicle() {
		return idVehicle;
	}
    
    public String getVehiculePosition() {
		return "Rover " + idVehicle + ": " + this.getPosition().getX() + " " + this.getPosition().getY() + " " + this.getDirection();
    }

	@Override
    public String toString() {
        return position + " " + direction.getSymbol();
    }
	
}
