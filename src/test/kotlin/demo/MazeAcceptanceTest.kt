package demo 

import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.hamcrest.CoreMatchers.`is` as _is

class MazeAcceptanceTest {

    @Test fun superSimpleSolvableMaze() {
        val maze = Maze(superSimpleSolvableMaze)
        val route: List<Cell> = maze.getSolution()
        assertThat(route[0].type, _is (Type.Start))
        assertThat(route[route.size-1].type, _is (Type.Finish))
        println(maze.getMazeAsStringWithRoute(route));
    }

    @Test
    fun simpleSolvableMaze() {
        val maze = Maze(simpleSolvableMaze)
        val route: List<Cell> = maze.getSolution()
        assertThat(route[0].type, _is (Type.Start))
        assertThat(route[route.size-1].type, _is (Type.Finish))
        println(maze.getMazeAsStringWithRoute(route));
    }

    @Test
    fun mazeWithNarrowWallCanBeSolved() {
        val maze = Maze(mazeWithANarrowWall)
        val route: List<Cell> = maze.getSolution()

        assertThat(route[0].type, _is (Type.Start))
        assertThat(route[route.size-1].type, _is (Type.Finish))
        println(maze.getMazeAsStringWithRoute(route));
    }

    @Test fun superSimpleSolvableMazeCanBePrinted() {
        val maze = Maze(superSimpleSolvableMaze)
        val route: List<Cell> = maze.getSolution()

        var mazeAsStringWithRoute = maze.getMazeAsStringWithRoute(route)
        assertThat(mazeAsStringWithRoute, _is (expectedSuperSimpleSolvableMazeWithRoute))
        println(maze.getMazeAsStringWithRoute(route));
    }

}

