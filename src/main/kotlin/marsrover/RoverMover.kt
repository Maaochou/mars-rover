package prep.marsrover

class RoverMover : MoveRover {

    private val listOfXDirections = listOf(RoverDirection.W, RoverDirection.E)
    private val listOfYDirections = listOf(RoverDirection.N, RoverDirection.S)

    private val listOfRotationCommands = listOf(RoverCommand.TL, RoverCommand.TR)
    private val toLeftRotationMap = mapOf(
        RoverDirection.N to RoverDirection.W,
        RoverDirection.W to RoverDirection.S,
        RoverDirection.S to RoverDirection.E,
        RoverDirection.E to RoverDirection.N,
    )
    private val toRightRotationMap = mapOf(
        RoverDirection.N to RoverDirection.E,
        RoverDirection.E to RoverDirection.S,
        RoverDirection.S to RoverDirection.W,
        RoverDirection.W to RoverDirection.N,
    )

    override fun move(marsRover: MarsRover, command: RoverCommand): MarsRover {
        if (listOfRotationCommands.contains(command))
            return rotate(marsRover, command);

        var moveBy = 1
        if (command == RoverCommand.B) {
            moveBy = moveBy * -1;
        }
        if (marsRover.direction == RoverDirection.W || marsRover.direction == RoverDirection.N) {
            moveBy = moveBy * -1;
        }
        val roverDirection: RoverDirection = marsRover.direction
        val x = if (listOfXDirections.contains(roverDirection)) marsRover.x + moveBy else marsRover.x
        val y = if (listOfYDirections.contains(roverDirection)) marsRover.y + moveBy else marsRover.y
        return MarsRover(x, y, roverDirection)
    }

    override fun move(
        marsRover: MarsRover,
        command: RoverCommand,
        obstacleMap: ObstacleMap
    ): MarsRover {
        // move rover
        val movedMarsRover = move(marsRover, command)

        // check if index out of bounds, if so rectify it
        val xLastIndex = obstacleMap.obstaclesMatrice[0].size - 1
        val yLastIndex = obstacleMap.obstaclesMatrice.size - 1

        var x = movedMarsRover.x
        var y = movedMarsRover.y
        if (x < 0 || x > xLastIndex)
            x = if (movedMarsRover.x < 0) xLastIndex + movedMarsRover.x + 1 else movedMarsRover.x - xLastIndex - 1
        if (y < 0 || y > yLastIndex)
            y = if (movedMarsRover.y < 0) yLastIndex + movedMarsRover.y + 1 else movedMarsRover.y - yLastIndex - 1

        // check if the rover is on an obstacle
        if (obstacleMap.obstaclesMatrice[y][x])
            return marsRover
        else
            return MarsRover(x, y, marsRover.direction)
    }

    private fun rotate(marsRover: MarsRover, command: RoverCommand): MarsRover {

        val direction = if (command == RoverCommand.TL)
            toLeftRotationMap[marsRover.direction]
        else toRightRotationMap[marsRover.direction]

        requireNotNull(direction) { "Invalid direction to rotate" }

        return MarsRover(marsRover.x, marsRover.y, direction);
    }
}