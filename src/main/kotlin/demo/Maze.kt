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


        var someRows: List<List<Cell>> = fileAsString.split(NEW_LINE_DELIMETER).mapIndexed { yIndex, line ->
            convertLine(line, yIndex)
        }


        someRows.forEachIndexed{yAxis, rowOnYAxis ->
            rowOnYAxis.forEachIndexed{xAxis, cell ->
                cell.down = getCellByCoordinates(someRows, cell.yAxis + 1, cell.xAxis)
                cell.up = getCellByCoordinates(someRows, cell.yAxis - 1, cell.xAxis)
                cell.left = getCellByCoordinates(someRows, cell.yAxis, cell.xAxis -1)
                cell.right = getCellByCoordinates(someRows, cell.yAxis , cell.xAxis + 1)
            }
        }

//
//        someRows = someRows.map { rows ->
//            rows.map { cell -> cell.copy(
//                    down = getCellByCoordinates(someRows, cell.yAxis + 1, cell.xAxis),
//                    up = getCellByCoordinates(someRows, cell.yAxis - 1, cell.xAxis),
//                    left = getCellByCoordinates(someRows, cell.yAxis, cell.xAxis -1),
//                    right = getCellByCoordinates(someRows, cell.yAxis + 1, cell.xAxis + 2)) }
//        }

        rows = someRows


        println(filename)
    }

    private fun getCellByCoordinates(someRows: List<List<Cell>>, yAxis: Int, xAxis: Int): Cell? {
        if (yAxis > 0 && yAxis <someRows.size){
            val rowOnYAxis = someRows.get(yAxis)
            if (xAxis > 0 && xAxis<rowOnYAxis.size){
                return rowOnYAxis.get(xAxis)
            }
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



