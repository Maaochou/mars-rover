package prep.marsrover

interface MoveRover {
    fun move(marsRover: MarsRover, command: RoverCommand): MarsRover

    fun move(marsRover: MarsRover, command: RoverCommand, obstacleMap: ObstacleMap): MarsRover
}