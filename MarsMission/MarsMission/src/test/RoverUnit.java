package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import marsmission.Board;
import marsmission.Direction;
import marsmission.Rover;

class RoverUnit {
	
	Board board = new Board(5, 5);
	Rover rover = new Rover(2, 2, Direction.N, board);
	Rover rover2 = new Rover(2, 3, Direction.N, board);
	Rover rover3 = new Rover(2, 1, Direction.N, board);
	
	@Test
    public void RoverRotateLeft() throws Exception {
        rover.rotateLeft();
        assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void RoverRotateRight() throws Exception {
        rover.rotateRight();
        assertEquals(Direction.E, rover.getDirection());

    }

    @Test
    public void RoverMoveForward() throws Exception {
    	rover2.moveForward();
        assertEquals(4, rover2.getPosition().getY()); 
    }

}
