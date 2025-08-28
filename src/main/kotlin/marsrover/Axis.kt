package prep.marsrover

enum class Axis {
    X, Y;

    fun rectify(pos: Int, maxPos: Int): Int =
        if (pos < 0) maxPos + pos + 1 else if (pos > maxPos) pos - maxPos - 1 else pos
}