package demo

data class Cell(val type: Type,
                val xAxis: Int,
                val yAxis: Int,
                val down: Cell? = null,
                val up: Cell? = null,
                val left: Cell? = null,
                val right: Cell? = null)



