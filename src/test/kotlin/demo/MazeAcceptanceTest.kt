package demo 

import org.apache.commons.io.FileUtils
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import java.io.File

class MazeAcceptanceTest {


    @Test fun superSimpleSolvableMaze() {
        val route: List<Cell> = Maze("super-simple-solvable-maze.txt").getSolution()

        assertThat(route[0].type, `is`(Type.Start))
        assertThat(route[route.size-1].type, `is`(Type.Finish))
    }

    @Test
    fun simpleSolvableMaze() {
        val maze = Maze("simple-solvable-maze.txt")
        val route: List<Cell> = maze.getSolution()

        assertThat(route[0].type, `is`(Type.Start))
        assertThat(route[route.size-1].type, `is`(Type.Finish))
        println(maze.getMazeAsStringWithRoute(route));
    }

    @Test fun superSimpleSolvableMazeCanBePrinted() {
        val maze = Maze("super-simple-solvable-maze.txt")
        val route: List<Cell> = maze.getSolution()

        var mazeAsStringWithRoute = maze.getMazeAsStringWithRoute(route)
        var expectedMazeWithRoute = FileUtils.readFileToString(
                File(javaClass.getClassLoader().getResource("expected-super-simple-solvable-maze-with-route.txt").file), CHARSET)
        assertThat(mazeAsStringWithRoute, `is`(expectedMazeWithRoute))


    }

}

