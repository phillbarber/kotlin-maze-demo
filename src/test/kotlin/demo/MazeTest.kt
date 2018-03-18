package demo

import demo.Type.*
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.CoreMatchers.`is` as _is
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MazeTest {

    @Test fun mazeLoadedFromFileHasCorrectNumberOfRows() {
        val maze = Maze(simpleSolvableMaze)
        assertThat(maze.rows.size, _is(25))
    }

    @Test fun mazeLoadedFromFileHasCorrectNumberOfColums() {
        val maze = Maze(simpleSolvableMaze)
        assertThat(maze.rows.size, _is(25))
        maze.rows.forEach{rowOfCells ->
            assertThat(rowOfCells.size, _is(44))

        }
    }
    @Test fun mazeLoadedFromFileHasWallsSurrounding() {
        val maze = Maze(simpleSolvableMaze)
        assertThat(maze.rows.size, _is(25))
        assertThat(maze.rows[0][0].type, _is(Wall))
        assertThat(maze.rows[0][43].type, _is(Wall))
        assertThat(maze.rows[24][0].type, _is(Wall))
        assertThat(maze.rows[24][43].type, _is(Wall))
    }

    @Test fun mazeLoadedFromFileHasStart() {
        val maze = Maze(simpleSolvableMaze)
        assertThat(maze.rows[1][1].type, _is(Start))
    }

    @Test fun mazeLoadedFromFileHasFinish() {
        val maze = Maze(simpleSolvableMaze)
        assertThat(maze.rows.size, _is(25))
        assertThat(maze.rows[18][13].type, _is(Finish))
    }

    @Test fun getStart() {
        val maze = Maze(simpleSolvableMaze)
        val start = maze.getStart()!!
        assertThat(start.type, _is(Start))
    }

    @Test fun startHasADownCellThatIsFree() {
        val maze = Maze(simpleSolvableMaze)
        val start = maze.getStart()!!
        assertThat(start.down!!.type, _is(Free))
    }

    @Test fun bottomCellHasANullCellOneDownFromIt() {
        val maze = Maze(simpleSolvableMaze)
        assertThat(maze.rows.get(24).get(0).down, _is(nullValue()))
    }

    @Test fun topCellHasANullCellOneUpFromIt() {
        val maze = Maze(simpleSolvableMaze)
        assertThat(maze.rows.get(0).get(0).up, _is(nullValue()))
    }

    @Test fun upDownLeftRightAllCorrect() {
        val maze = Maze(simpleSolvableMaze)
        val cell = maze.rows.get(4).get(4)
        val up = cell.up!!
        val left = up.left!!
        val down = left.down!!
        val down1 = down.down!!
        val right = down1.right!!
        val up1 = right.up!!
        assertThat(up1, _is(equalTo(cell)));
    }
}

