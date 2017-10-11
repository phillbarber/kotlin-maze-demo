package demo

import org.apache.commons.io.FileUtils
import java.io.File

private val CHARSET = "UTF-8"

class Maze(filename: String) {


    val rows: List<List<Cell>>

    init {
        var fileAsString = FileUtils.readFileToString(
                File(javaClass.getClassLoader().getResource(filename).file), CHARSET)
        var split = fileAsString.split("\n")
        rows = split.map{line ->
            convertLine(line)
        }




        println(filename)
    }

    private fun convertLine(line: String) :List<Cell> {
        return listOf(Cell())
    }


    fun stuff(): String {
        return "Yay"
    }

    fun solve(): SolvedMaze {
        return SolvedMaze()
    }


}



