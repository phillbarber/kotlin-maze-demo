package demo 

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import kotlin.test.assertEquals
import org.junit.Test

class MazeAcceptanceTest {
    @Test fun simpleSolvableMaze() {
        val solvedMaze: SolvedMaze = Maze("simple-solvable-maze.txt").solve()

        val route: List<Cell> = solvedMaze.getRoute()

        assertThat(route[0].type, `is`(Type.Start))


        route.g
        //assertThat(route[route.l].type, `is`(Type.Start))
        solvedMaze.printSolution()

    }


}

