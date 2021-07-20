package diego.cursos.model;


import diego.cursos.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class PersonTest implements ModelTests {
    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(1L, "Joe", "Buck");
        //then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Buck", person.getLastName())
        );

    }

    @Test
    void groupedAssertionMsgs() {
        //given
        Person person = new Person(1L, "Joe", "Buck");
        //then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName(), "First Name Failed"),
                () -> assertEquals("Buck", person.getLastName(), "Last Name Failed")
        );

    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTest() {

    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 3, name = "This is the {displayName} : {currentRepetition} - {totalRepetitions}")
    void assignmentTest(){

    }
}