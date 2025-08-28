package prep.marsrover

import kotlin.test.Test
import kotlin.test.assertEquals

class MarsRoverFacingAnObstacleTest {

    val moveRover: MoveRover = RoverMover()

    @Test
    fun mars_rover_should_go_forward_facing_east_on_map_with_no_obstacles() {
        //Given
        val obstacleMap = arrayOf(
            arrayOf(false, false, false), arrayOf(false, false, false), arrayOf(false, false, false)
        )

        val marsRover = MarsRover(1, 1, RoverDirection.E)
        //When
        val resultMarsRover = moveRover.move(marsRover, RoverCommand.F, obstacleMap)
        //Then
        val expectedMarsRover = MarsRover(2, 1, RoverDirection.E)
        assertEquals(expectedMarsRover, resultMarsRover)
    }

    @Test
    fun mars_rover_should_face_an_obstacle_going_forward_facing_west() {
        //Given
        val obstacleMap = arrayOf(
            arrayOf(false, false, false), arrayOf(false, false, false), arrayOf(false, true, false)
        )

        val marsRover = MarsRover(2, 2, RoverDirection.W)
        //When
        val resultMarsRover = moveRover.move(marsRover, RoverCommand.F, obstacleMap)
        //Then
        val expectedMarsRover = MarsRover(2, 2, RoverDirection.W)
        assertEquals(expectedMarsRover, resultMarsRover)
    }

    @Test
    fun mars_rover_should_face_an_obstacle_going_backward_facing_east() {
        //Given
        val obstacleMap = arrayOf(
            arrayOf(false, false, false), arrayOf(false, false, false), arrayOf(true, false, false)
        )

        val marsRover = MarsRover(2, 2, RoverDirection.E)
        //When
        val resultMarsRover = moveRover.move(marsRover, RoverCommand.F, obstacleMap)
        //Then
        val expectedMarsRover = MarsRover(2, 2, RoverDirection.E)
        assertEquals(expectedMarsRover, resultMarsRover)
    }

    @Test
    fun mars_rover_should_face_an_obstacle_going_forward_facing_north() {
        //Given
        val obstacleMap = arrayOf(
            arrayOf(false, false, false), arrayOf(false, false, false), arrayOf(false, false, true)
        )

        val marsRover = MarsRover(2, 0, RoverDirection.N)
        //When
        val resultMarsRover = moveRover.move(marsRover, RoverCommand.F, obstacleMap)
        //Then
        val expectedMarsRover = MarsRover(2, 0, RoverDirection.N)
        assertEquals(expectedMarsRover, resultMarsRover)
    }
}