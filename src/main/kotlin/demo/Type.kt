package demo

val TRAIL_CHARACTER = "."

enum class Type(val value: String) {
    Free(" "),
    Wall("#"),
    Start("S"),
    Finish("F");
}

fun fromChar(character: Char) : Type {
    val map = character.toString().map { s ->
        when (s) {
            'S' -> Type.Start
            ' ' -> Type.Free
            '#' -> Type.Wall
            'F' -> Type.Finish
            else -> {
                throw IllegalArgumentException("Unknown character $s")
            }
        }
    }
    return map.get(0);
}
