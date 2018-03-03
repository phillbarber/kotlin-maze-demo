package demo 

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Ignore
import kotlin.test.assertEquals
import org.junit.Test

class MazeAcceptanceTest {


    @Test fun superSimpleSolvableMaze() {
        val route: List<Cell> = Maze("super-simple-solvable-maze.txt").solve()

        assertThat(route[0].type, `is`(Type.Start))
        assertThat(route[route.size-1].type, `is`(Type.Finish))
    }

    @Test @Ignore
    fun simpleSolvableMaze() {
        val route: List<Cell> = Maze("simple-solvable-maze.txt").solve()

        assertThat(route[0].type, `is`(Type.Start))
        assertThat(route[route.size-1].type, `is`(Type.Finish))
    }


}

