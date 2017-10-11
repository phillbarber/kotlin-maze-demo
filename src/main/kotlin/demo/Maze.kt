package demo

import org.apache.commons.io.FileUtils
import java.io.File

class Maze(filename: String) {


    private val CHARSET = "UTF-8"

    init {
        var fileAsString = FileUtils.readFileToString(
                File(javaClass.getClassLoader().getResource(filename).file), CHARSET)
        var split = fileAsString.split("\n")
        split.forEach{line ->
            convertLine(line)
        }




        println(filename)
    }

    private fun convertLine(line: String) {
        println(line);
    }


    fun stuff(): String {
        return "Yay"
    }

    fun solve(): SolvedMaze {
        return SolvedMaze()
    }

    fun getRows(): List<List<Cell>> {
        return emptyList()
    }
}



