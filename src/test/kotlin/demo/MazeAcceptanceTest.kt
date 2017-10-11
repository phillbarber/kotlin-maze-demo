package demo 

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Ignore
import kotlin.test.assertEquals
import org.junit.Test

class MazeAcceptanceTest {
    @Test @Ignore fun simpleSolvableMaze() {
        val solvedMaze: SolvedMaze = Maze("simple-solvable-maze.txt").solve()

        val route: List<Cell> = solvedMaze.getRoute()
        assertThat(route[0].type, `is`(Type.Start))
        assertThat(route[route.size].type, `is`(Type.Finish))
        solvedMaze.printSolution()
    }


}

