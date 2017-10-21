package demo

import demo.Type.*
import org.hamcrest.CoreMatchers.*
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

    @Test fun bottomCellHasANullCellOneDownFromIt() {
        val maze = Maze("simple-solvable-maze.txt")
        assertThat(maze.rows.get(24).get(0).down, `is`(nullValue()))
    }

    @Test fun topCellHasANullCellOneUpFromIt() {
        val maze = Maze("simple-solvable-maze.txt")
        assertThat(maze.rows.get(0).get(0).up, `is`(nullValue()))
    }

    @Test fun upDownLeftRightAllCorrect() {
        val maze = Maze("simple-solvable-maze.txt")
        val cell = maze.rows.get(4).get(4)
        val up = cell.up!!
        val left = up.left!!
        val down = left.down!!
        val down1 = down.down!!
        val right = down1.right!!
        val up1 = right.up!!
        assertThat(up1, `is`(equalTo(cell)));
    }
}

