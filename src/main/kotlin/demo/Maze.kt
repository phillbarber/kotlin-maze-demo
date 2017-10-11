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


        rows = fileAsString.split(NEW_LINE_DELIMETER).mapIndexed { yIndex, line ->
            convertLine(line, yIndex)
        }

        println(filename)
    }

    private fun convertLine(line: String, yIndex: Int): List<Cell> {
        return line.chars().toArray().mapIndexed { xIndex, character -> Cell(character.toChar(), xIndex, yIndex) }
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



