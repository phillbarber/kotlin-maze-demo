package demo

import demo.Type.*
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
    @Test fun mazeLoadedFromFileHasWallsSurrounding() {
        val maze = Maze("simple-solvable-maze.txt")
        assertThat(maze.rows.size, `is`(25))
        assertThat(maze.rows[0][0].type, `is`(Wall))
        assertThat(maze.rows[0][43].type, `is`(Wall))
        assertThat(maze.rows[24][0].type, `is`(Wall))
        assertThat(maze.rows[24][43].type, `is`(Wall))
    }

    @Test fun mazeLoadedFromFileHasStart() {
        val maze = Maze("simple-solvable-maze.txt")
        assertThat(maze.rows[1][1].type, `is`(Start))
    }

    @Test fun mazeLoadedFromFileHasFinish() {
        val maze = Maze("simple-solvable-maze.txt")
        assertThat(maze.rows.size, `is`(25))
        assertThat(maze.rows[14][35].type, `is`(Finish))
    }

    @Test fun getStart() {
        val maze = Maze("simple-solvable-maze.txt")
        val start = maze.getStart()!!
        assertThat(start.type, `is`(Start))
    }

    @Test fun startHasADownCellThatIsFree() {
        val maze = Maze("simple-solvable-maze.txt")
        val start = maze.getStart()!!
        assertThat(start.down!!.type, `is`(Free))
    }
}

