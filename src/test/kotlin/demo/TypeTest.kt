package demo

import demo.Type.*
import org.hamcrest.CoreMatchers.`is` as _is
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


class TypeTest {

    @Test fun fromCharacterForTypeOfFree(){
        assertThat(fromChar(' '), _is(Free))
    }

    @Test fun fromCharacterForTypeOfWall(){
        assertThat(fromChar('#'), _is(Wall))
    }

    @Test fun fromCharacterForTypeOfStart(){
        assertThat(fromChar('S'), _is(Start))
    }

    @Test fun fromCharacterForTypeOfFinish(){
        assertThat(fromChar('F'), _is(Finish))
    }

}
