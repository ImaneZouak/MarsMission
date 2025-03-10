package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import marsmission.Board;
import marsmission.Direction;
import marsmission.Rover;

class IntegrationTest {

	@Test
    public void roverMoveOnGrid() throws Exception {
        Board board = new Board(5, 5);        
        Rover rover = new Rover(1, 2, Direction.N, board); 
        rover.moveOnGrid("LMLMLMLMM");
        assertEquals(1, rover.getPosition().getX());
        assertEquals(3, rover.getPosition().getY());
        assertEquals(Direction.N, rover.getDirection());
    }
	
	@Test
    public void roverMoveToOccupiedCell() throws Exception {
        Board board = new Board(5, 5);
        Rover rover1 = new Rover(1, 2, Direction.N, board);
        Rover rover2 = new Rover(1, 3, Direction.N, board);
        rover1.moveOnGrid("M");
        assertEquals(1, rover1.getPosition().getX());
        assertEquals(2, rover1.getPosition().getY());    
        assertEquals(1, rover2.getPosition().getX());
        assertEquals(3, rover2.getPosition().getY()); 
    }
	
	@Test
    public void roverMoveOutOfTheGrid() throws Exception {
        Board board = new Board(5, 5);
        Rover rover3 = new Rover(1, 5, Direction.N, board);
        rover3.moveOnGrid("M");
        assertEquals(1, rover3.getPosition().getX());
        assertEquals(5, rover3.getPosition().getY());    
    }

}
