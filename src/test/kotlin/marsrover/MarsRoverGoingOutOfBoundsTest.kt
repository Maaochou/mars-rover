package prep.marsrover

import kotlin.test.Test
import kotlin.test.assertEquals

class MarsRoverGoingOutOfBoundsTest {

    val moveRover: MoveRover = RoverMover()

    @Test
    fun mars_rover_should_go_out_of_bounds_and_appear_in_the_other_side_going_forward_facing_north() {
        //Given
        val obstacleMap = ObstacleMap(
            arrayOf(
                arrayOf(false, false, false),
                arrayOf(false, false, false),
                arrayOf(false, true, false)
            )
        );

        val marsRover = MarsRover(2, 0, RoverDirection.N)
        //When
        val resultMarsRover = moveRover.move(marsRover, RoverCommand.F, obstacleMap)
        //Then
        val expectedMarsRover = MarsRover(2, 2, RoverDirection.N)
        assertEquals(expectedMarsRover, resultMarsRover)
    }

    @Test
    fun mars_rover_should_go_out_of_bounds_and_appear_in_the_other_side_going_forward_facing_south() {
        //Given
        val obstacleMap = ObstacleMap(
            arrayOf(
                arrayOf(false, false, false),
                arrayOf(false, false, false),
                arrayOf(false, true, false)
            )
        );

        val marsRover = MarsRover(2, 2, RoverDirection.S)
        //When
        val resultMarsRover = moveRover.move(marsRover, RoverCommand.F, obstacleMap)
        //Then
        val expectedMarsRover = MarsRover(2, 0, RoverDirection.S)
        assertEquals(expectedMarsRover, resultMarsRover)
    }

    @Test
    fun mars_rover_should_go_out_of_bounds_and_appear_in_the_other_side_going_forward_facing_east() {
        //Given
        val obstacleMap = ObstacleMap(
            arrayOf(
                arrayOf(false, false, false),
                arrayOf(false, false, false),
                arrayOf(false, true, false)
            )
        );

        val marsRover = MarsRover(2, 2, RoverDirection.E)
        //When
        val resultMarsRover = moveRover.move(marsRover, RoverCommand.F, obstacleMap)
        //Then
        val expectedMarsRover = MarsRover(0, 2, RoverDirection.E)
        assertEquals(expectedMarsRover, resultMarsRover)
    }

    @Test
    fun mars_rover_should_go_out_of_bounds_and_appear_in_the_other_side_going_forward_facing_west() {
        //Given
        val obstacleMap = ObstacleMap(
            arrayOf(
                arrayOf(false, false, false),
                arrayOf(false, false, false),
                arrayOf(false, true, false)
            )
        );

        val marsRover = MarsRover(0, 2, RoverDirection.W)
        //When
        val resultMarsRover = moveRover.move(marsRover, RoverCommand.F, obstacleMap)
        //Then
        val expectedMarsRover = MarsRover(2, 2, RoverDirection.W)
        assertEquals(expectedMarsRover, resultMarsRover)
    }
}