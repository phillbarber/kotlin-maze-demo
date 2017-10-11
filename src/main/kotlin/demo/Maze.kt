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


        rows = fileAsString.split(NEW_LINE_DELIMETER).map{ line ->
            convertLine(line)
        }




        println(filename)
    }

    private fun convertLine(line: String) :List<Cell> {
        return line.chars().toArray().map{ character -> Cell() }
    }

    fun solve(): SolvedMaze {
        return SolvedMaze()
    }
}



