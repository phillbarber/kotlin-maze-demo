package demo

class Cell(character: Char, xAxis: Int, yAxis: Int) {

    val xAxis: Int
    val yAxis: Int
    val  type: Type

    init{
        type = fromChar(character)
        this.xAxis = xAxis
        this.yAxis = yAxis
    }
}

