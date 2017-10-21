package demo

data class Cell(val type: Type,
                val xAxis: Int,
                val yAxis: Int,
                var down: Cell? = null,
                var up: Cell? = null,
                var left: Cell? = null,
                var right: Cell? = null){
    override fun toString(): String {
        return "Cell(type=$type, xAxis=$xAxis, yAxis=$yAxis)"
    }
}





