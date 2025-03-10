package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import marsmission.Position;

class PositionUnit {

	@Test
	public void testPositionEquality() {
        Position position1 = new Position(2, 3);
        Position position2 = new Position(2, 3);
        Position position3 = new Position(4, 5);

        assertTrue(position1.isEqual(position2));
        assertFalse(position1.isEqual(position3));
    }

}
