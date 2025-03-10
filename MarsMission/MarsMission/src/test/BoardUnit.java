package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import marsmission.Board;
import marsmission.Direction;
import marsmission.Position;
import marsmission.Rover;

class BoardUnit {
	Board board = new Board(5, 5);
	Rover rover = new Rover(2, 2, Direction.N, board);
	
	@Test
	public void testBoardValidPosition() {
        Board board = new Board(5, 5);

        assertTrue(board.isValidPosition(3, 3));
        assertFalse(board.isValidPosition(7, 7));
    }
	
	@Test
    public void testBoardCellIsOccupied() {
        assertTrue(board.cellIsOccupied(new Position(2, 2)));
    }

}
