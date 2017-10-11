package demo

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MazeTest {
    @Test fun mazeCanBeLoadedFromFile() {
        val maze = Maze("simple-solvable-maze.txt")
        assertThat(maze.rows.size, `is`(25))
    }


}

