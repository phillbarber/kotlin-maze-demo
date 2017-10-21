package demo

enum class Type(){
    Free(),
    Wall(),
    Start(),
    Finish();
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
