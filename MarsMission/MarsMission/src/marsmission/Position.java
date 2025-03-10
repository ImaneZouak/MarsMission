package marsmission;

public class Position {
	
	private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { 
    	return x; 
    }
    
    public int getY() { 
    	return y; 
    }

    public void setX(int x) { 
    	this.x = x; 
    }
    
    public void setY(int y) { 
    	this.y = y; 
    }
    
    // Check if position is equal with another position and return true
    public boolean isEqual(Position position){
		return this.x == position.getX() && this.y == position.getY();	
    }
    /*
    public boolean isEqual(int x, int y){
		return this.x == x && this.y == y;	
    }
	*/
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
