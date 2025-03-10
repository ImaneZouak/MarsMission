package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import marsmission.Direction;

class DirectionUnit {

	@Test
    public void InvalidDirection() {
    	try {
            Direction.valueOf("X"); 
            fail("Exception not caught");
        } catch (Exception e) {
            System.out.println("Exception caught : " + e.getMessage());
        }    
    }

}
