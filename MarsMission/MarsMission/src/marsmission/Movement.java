package marsmission;

public interface Movement {
	// Move the rover on the grid with commands M (move), L (turnleft), R (turnright)
    public void moveOnGrid(String movements) throws Exception;
    
	// Command M for move forward the rover 
	public void moveForward() throws Exception;
	// Command L for turn left the rover
    public void rotateLeft() throws Exception;
    // Command R for turn right the rover
    public void rotateRight() throws Exception;
}
