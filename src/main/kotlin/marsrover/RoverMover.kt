package prep.marsrover

class RoverMover : MoveRover {

    override fun move(marsRover: MarsRover, command: RoverCommand): MarsRover {

        if (command.changeDirection) return MarsRover(marsRover.x, marsRover.y, marsRover.direction.turn(command));
        8
        val roverDirection: RoverDirection = marsRover.direction

        val moveBy = command.moveByMultiplier * roverDirection.moveByMultiplier

        return MarsRover(
            if (roverDirection.axis == Axis.X) marsRover.x + moveBy else marsRover.x,
            if (roverDirection.axis == Axis.Y) marsRover.y + moveBy else marsRover.y,
            roverDirection
        )
    }

    override fun move(
        marsRover: MarsRover, command: RoverCommand, obstaclesMap: Array<Array<Boolean>>
    ): MarsRover {
        // move rover
        val movedMarsRover = move(marsRover, command)

        // check if index out of bounds, if so rectify it
        val x = if (movedMarsRover.direction.axis == Axis.X) movedMarsRover.direction.axis.rectify(
            movedMarsRover.x, obstaclesMap[0].size - 1
        ) else movedMarsRover.x
        val y = if (movedMarsRover.direction.axis == Axis.Y) movedMarsRover.direction.axis.rectify(
            movedMarsRover.y, obstaclesMap.size - 1
        ) else movedMarsRover.y

        // check if the rover is on an obstacle
        if (obstaclesMap[y][x]) return marsRover
        else return MarsRover(x, y, marsRover.direction)
    }
}