package demo

class Cell(character: Char) {

    val  type: Type

    init{
        type = fromChar(character)
    }
}

