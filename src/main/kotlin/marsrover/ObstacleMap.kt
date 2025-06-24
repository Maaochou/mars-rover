package prep.marsrover

// TODO Delete this and use 2 dim array instead ?
data class ObstacleMap(val obstaclesMatrice: Array<Array<Boolean>>) {

    // TODO Generated code, figure out the syntax.
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ObstacleMap

        if (!obstaclesMatrice.contentDeepEquals(other.obstaclesMatrice)) return false

        return true
    }

    override fun hashCode(): Int {
        return obstaclesMatrice.contentDeepHashCode()
    }

}