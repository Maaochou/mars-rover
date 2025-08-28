package prep.marsrover

interface MoveRover {
    fun move(marsRover: MarsRover, command: RoverCommand): MarsRover

    fun move(marsRover: MarsRover, command: RoverCommand, obstaclesMap: Array<Array<Boolean>>): MarsRover
}