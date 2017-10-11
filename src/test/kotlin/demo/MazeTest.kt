package demo

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MazeTest {

    @Test fun mazeLoadedFromFileHasCorrectNumberOfRows() {
        val maze = Maze("simple-solvable-maze.txt")
        assertThat(maze.rows.size, `is`(25))
    }

    @Test fun mazeLoadedFromFileHasCorrectNumberOfColums() {
        val maze = Maze("simple-solvable-maze.txt")
        assertThat(maze.rows.size, `is`(25))
        maze.rows.forEach{rowOfCells ->
            assertThat(rowOfCells.size, `is`(44))

        }
    }
}

