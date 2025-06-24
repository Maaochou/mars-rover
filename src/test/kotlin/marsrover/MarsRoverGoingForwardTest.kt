package prep.marsrover

import kotlin.test.Test
import kotlin.test.assertEquals

class MarsRoverGoingForwardTest {

    val moveRover: MoveRover = RoverMover()

    @Test
    fun mars_rover_facing_north_should_go_forward() {
        // Given
        val marsRover = MarsRover(5, 5, RoverDirection.N);
        // When
        val resultingMarsRover = moveRover.move(marsRover, RoverCommand.F)
        // Then
        val expectedMarsRover = MarsRover(5, 4, RoverDirection.N)
        assertEquals(expectedMarsRover, resultingMarsRover)
    }

    @Test
    fun mars_rover_facing_south_should_go_forward() {
        // Given
        val marsRover = MarsRover(5, 5, RoverDirection.S);
        // When
        val resultingMarsRover = moveRover.move(marsRover, RoverCommand.F)
        // Then
        val expectedMarsRover = MarsRover(5, 6, RoverDirection.S)
        assertEquals(expectedMarsRover, resultingMarsRover)
    }

    @Test
    fun mars_rover_facing_east_should_go_forward() {
        // Given
        val marsRover = MarsRover(5, 5, RoverDirection.E);
        // When
        val resultingMarsRover = moveRover.move(marsRover, RoverCommand.F)
        // Then
        val expectedMarsRover = MarsRover(6, 5, RoverDirection.E)
        assertEquals(expectedMarsRover, resultingMarsRover)
    }

    @Test
    fun mars_rover_facing_west_should_go_forward() {
        // Given
        val marsRover = MarsRover(5, 5, RoverDirection.W);
        // When
        val resultingMarsRover = moveRover.move(marsRover, RoverCommand.F)
        // Then
        val expectedMarsRover = MarsRover(4, 5, RoverDirection.W)
        assertEquals(expectedMarsRover, resultingMarsRover)
    }
}