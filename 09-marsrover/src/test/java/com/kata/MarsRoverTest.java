package com.kata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {

    @Test
    public void shouldMoveForwardNorth() {
        MarsRover.Rover rover = new MarsRover.Rover(0, 0, MarsRover.Direction.N);
        rover.move("M");
        assertEquals("0 1 N", rover.toString());
    }

    @Test
    public void shouldMoveForwardEast() {
        MarsRover.Rover rover = new MarsRover.Rover(0, 0, MarsRover.Direction.E);
        rover.move("M");
        assertEquals("1 0 E", rover.toString());
    }

    @Test
    public void shouldTurnLeftFromNorthToWest() {
        MarsRover.Rover rover = new MarsRover.Rover(0, 0, MarsRover.Direction.N);
        rover.move("L");
        assertEquals("0 0 W", rover.toString());
    }

    @Test
    public void shouldTurnRightFromNorthToEast() {
        MarsRover.Rover rover = new MarsRover.Rover(0, 0, MarsRover.Direction.N);
        rover.move("R");
        assertEquals("0 0 E", rover.toString());
    }

    @Test
    public void shouldHandleComplexCommandSequence() {
        MarsRover.Rover rover = new MarsRover.Rover(1, 2, MarsRover.Direction.N);
        rover.move("LMLMLMLMM");
        assertEquals("1 3 N", rover.toString());
    }

    @Test
    public void shouldThrowExceptionForInvalidCommand() {
        MarsRover.Rover rover = new MarsRover.Rover(0, 0, MarsRover.Direction.N);
        assertThrows(IllegalArgumentException.class, () -> rover.move("MX"));
    }

    @Test
    public void shouldThrowExceptionForNullCommands() {
        MarsRover.Rover rover = new MarsRover.Rover(0, 0, MarsRover.Direction.N);
        assertThrows(IllegalArgumentException.class, () -> rover.move(null));
    }

    @Test
    public void shouldThrowExceptionForEmptyCommands() {
        MarsRover.Rover rover = new MarsRover.Rover(0, 0, MarsRover.Direction.N);
        assertThrows(IllegalArgumentException.class, () -> rover.move(""));
    }

    @Test
    public void shouldNotAllowNegativeStartingCoordinates() {
        assertThrows(IllegalArgumentException.class, () -> new MarsRover.Rover(-1, 0, MarsRover.Direction.N));
    }

    @Test
    public void shouldNotAllowRoverOutsideMap() {
        MarsRover.Rover rover = new MarsRover.Rover(0, 0, MarsRover.Direction.S);
        assertThrows(IllegalStateException.class, () -> rover.move("M"));
    }

    @Test
    public void shouldStopBeforeObstacle() {
        MarsRover.Rover rover = new MarsRover.Rover(0, 0, MarsRover.Direction.N, 5, 5);
        rover.addObstacle(0, 2);
        rover.move("MMM");
        assertEquals("0 1 N (OBSTÁCULO DETECTADO)", rover.toString());
        assertTrue(rover.obstacleFound);
    }

    @Test
    public void shouldAddObstacleInsideMap() {
        MarsRover.Rover rover = new MarsRover.Rover(2, 2, MarsRover.Direction.E, 5, 5);
        assertDoesNotThrow(() -> rover.addObstacle(4, 4));
    }

    @Test
    public void shouldRejectObstacleOutsideMap() {
        MarsRover.Rover rover = new MarsRover.Rover(0, 0, MarsRover.Direction.N, 3, 3);
        assertThrows(IllegalArgumentException.class, () -> rover.addObstacle(4, 4));
    }

    @Test
    public void shouldContinueWithoutObstacle() {
        MarsRover.Rover rover = new MarsRover.Rover(0, 0, MarsRover.Direction.N, 5, 5);
        rover.move("MM");
        assertEquals("0 2 N", rover.toString());
        assertFalse(rover.obstacleFound);
    }

    @Test
    public void shouldHandleObstacleAfterTurn() {
        MarsRover.Rover rover = new MarsRover.Rover(1, 1, MarsRover.Direction.N, 5, 5);
        rover.addObstacle(2, 1);
        rover.move("RMM");
        assertEquals("1 1 E (OBSTÁCULO DETECTADO)", rover.toString());
        assertTrue(rover.obstacleFound);
    }
}
