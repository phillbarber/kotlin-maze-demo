package demo

import org.apache.commons.io.FileUtils
import java.io.File

val CHARSET = "UTF-8"
private val NEW_LINE_DELIMETER = "\n"

class Maze(filename: String) {


    val rows: List<List<Cell>>


    init {
        var fileAsString = FileUtils.readFileToString(
                File(javaClass.getClassLoader().getResource(filename).file), CHARSET)


        var gridOfRows: List<List<Cell>> = fileAsString.split(NEW_LINE_DELIMETER).mapIndexed { yIndex, line ->
            createListOfCellsForARow(line, yIndex)
        }


        addDownUpLeftRightToCells(gridOfRows)

        rows = gridOfRows

    }

    private fun addDownUpLeftRightToCells(gridOfRows: List<List<Cell>>) {
        gridOfRows.forEachIndexed { yAxis, rowOnYAxis ->
            rowOnYAxis.forEachIndexed { xAxis, cell ->
                cell.down = getCellByCoordinates(gridOfRows, cell.yAxis + 1, cell.xAxis)
                cell.up = getCellByCoordinates(gridOfRows, cell.yAxis - 1, cell.xAxis)
                cell.left = getCellByCoordinates(gridOfRows, cell.yAxis, cell.xAxis - 1)
                cell.right = getCellByCoordinates(gridOfRows, cell.yAxis, cell.xAxis + 1)
            }
        }
    }

    private fun getCellByCoordinates(gridOfCells: List<List<Cell>>, yAxis: Int, xAxis: Int): Cell? {
        if (yAxis > 0 && yAxis < gridOfCells.size){
            val rowOnYAxis = gridOfCells.get(yAxis)
            if (xAxis > 0 && xAxis<rowOnYAxis.size){
                return rowOnYAxis.get(xAxis)
            }
        }
        return null
    }

    private fun createListOfCellsForARow(line: String, yIndex: Int): List<Cell> {
        return line.chars().toArray().mapIndexed { xIndex, character ->
            Cell(type = fromChar(character.toChar()), xAxis = xIndex, yAxis = yIndex) }
    }

    fun getSolution(): List<Cell> {
        val finish = getFinish(getStart(), mutableListOf())
        finish.forEach { println(it) }
        return finish
    }

    private fun getFinish(cell: Cell?, route: MutableList<Cell>): List<Cell> {
        if (cell != null){

            route.add(cell)
            if (cell.type == Type.Finish){
                return route;
            }

            if (shouldVisitCell(cell.down, route)){
                return getFinish(cell.down, route);
            }

            if (shouldVisitCell(cell.left, route)){
                return getFinish(cell.left, route);
            }

            if (shouldVisitCell(cell.right, route)){
                return getFinish(cell.right, route);
            }

            if (shouldVisitCell(cell.up, route)){
                return getFinish(cell.up, route);
            }
        }
        return route;


    }

    private fun shouldVisitCell(down: Cell?, route: List<Cell>) = down != null && down!!.type != Type.Wall && !route.contains(down)

    fun getStart(): Cell? {
        rows.forEach { cells ->
            cells.forEach { cell ->
                if (cell.type == Type.Start) {
                    return cell;
                }
            }
        }
        return null
    }

    fun getMazeAsStringWithRoute(route: List<Cell>) : String {
        val result = StringBuffer()
        this.rows.forEach {
            it.forEach { cell ->
                if (route.contains(cell) && cell.type == Type.Free){
                    result.append(TRAIL_CHARACTER)
                }
                else{
                    result.append(cell.type.value)
                }
            }

            result.append("\n");
        }

        return result.toString();
    }
}



