package prep.marsrover

enum class RoverDirection(val moveByMultiplier: Int, val axis: Axis) {
    N(-1, Axis.Y), E(1, Axis.X), S(1, Axis.Y), W(-1, Axis.X);

    fun turn(command: RoverCommand): RoverDirection {

        if (!command.changeDirection) {
            return this
        }
        if (command == RoverCommand.TL) {
            return when (this) {
                N -> W
                W -> S
                S -> E
                E -> N
            }
        }
        if (command == RoverCommand.TR) {
            return when (this) {
                N -> E
                E -> S
                S -> W
                W -> N
            }
        }

        return this;
    }
}