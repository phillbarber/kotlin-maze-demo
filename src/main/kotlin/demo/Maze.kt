package demo

import org.apache.commons.io.FileUtils
import java.io.File

private val CHARSET = "UTF-8"
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


        println(filename)
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

    fun solve(): SolvedMaze {
        return SolvedMaze()
    }

    fun getStart(): Cell? {
        rows.forEach { cells ->
            cells.forEach { cell ->
                if (cell.type == Type.Start) {
                    return cell;
                }
            }
        }
        return null;
    }
}



