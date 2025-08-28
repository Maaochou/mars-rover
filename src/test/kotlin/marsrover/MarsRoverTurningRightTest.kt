package prep.marsrover

import kotlin.test.Test
import kotlin.test.assertEquals

class MarsRoverTurningRightTest {

    val moveRover: MoveRover = RoverMover()

    @Test
    fun mars_rover_facing_north_should_go_turn_right() {
        // Given
        val marsRover = MarsRover(5, 5, RoverDirection.N);
        // When
        val resultingMarsRover = moveRover.move(marsRover, RoverCommand.TR)
        // Then
        val expectedMarsRover = MarsRover(5, 5, RoverDirection.E);
        assertEquals(expectedMarsRover, resultingMarsRover)
    }

    @Test
    fun mars_rover_facing_south_should_turn_right() {
        // Given
        val marsRover = MarsRover(5, 5, RoverDirection.S);
        // When
        val resultingMarsRover = moveRover.move(marsRover, RoverCommand.TR)
        // Then
        val expectedMarsRover = MarsRover(5, 5, RoverDirection.W);
        assertEquals(expectedMarsRover, resultingMarsRover)
    }

    @Test
    fun mars_rover_facing_east_should_turn_right() {
        // Given
        val marsRover = MarsRover(5, 5, RoverDirection.E);
        // When
        val resultingMarsRover = moveRover.move(marsRover, RoverCommand.TR)
        // Then
        val expectedMarsRover = MarsRover(5, 5, RoverDirection.S);
        assertEquals(expectedMarsRover, resultingMarsRover)
    }

    @Test
    fun mars_rover_facing_west_should_turn_right() {
        // Given
        val marsRover = MarsRover(5, 5, RoverDirection.W);
        // When
        val resultingMarsRover = moveRover.move(marsRover, RoverCommand.TR)
        // Then
        val expectedMarsRover = MarsRover(5, 5, RoverDirection.N);
        assertEquals(expectedMarsRover, resultingMarsRover)
    }
}