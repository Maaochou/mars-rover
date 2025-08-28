package prep.marsrover

enum class RoverCommand(val changeDirection: Boolean, val moveByMultiplier: Int) {
    F(false, 1), B(false, -1), TL(true, 0), TR(true, 0)
}