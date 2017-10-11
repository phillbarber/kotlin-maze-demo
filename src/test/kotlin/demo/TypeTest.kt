package demo

import demo.Type.*
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


class TypeTest {

    @Test fun fromCharacterForTypeOfFree(){
        assertThat(fromChar(' '), `is`(Free))
    }

    @Test fun fromCharacterForTypeOfWall(){
        assertThat(fromChar('#'), `is`(Wall))
    }

    @Test fun fromCharacterForTypeOfStart(){
        assertThat(fromChar('S'), `is`(Start))
    }

    @Test fun fromCharacterForTypeOfFinish(){
        assertThat(fromChar('F'), `is`(Finish))
    }

}
