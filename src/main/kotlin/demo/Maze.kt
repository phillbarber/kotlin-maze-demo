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


        var someRows: List<List<Cell>>? = null;

        someRows = fileAsString.split(NEW_LINE_DELIMETER).mapIndexed { yIndex, line ->
            convertLine(line, yIndex)
        }

        someRows = someRows.map { rowsWithNoUpCell ->
            rowsWithNoUpCell.map { cell ->
                cell.copy(down = getCellOneDownFromCell(someRows, cell)) }

        }

        rows = someRows!!


        println(filename)
    }

    private fun getCellOneDownFromCell(someRows: List<List<Cell>>?, cell: Cell): Cell? {
        val rowsOnYAxis = someRows!!.get(cell.yAxis)
        val yAxisOfCellOneDown = cell.yAxis + 1
        if (yAxisOfCellOneDown > 0 && yAxisOfCellOneDown <rowsOnYAxis.size){
            return rowsOnYAxis.get(yAxisOfCellOneDown)
        }
        return null
    }

    private fun convertLine(line: String, yIndex: Int): List<Cell> {
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



