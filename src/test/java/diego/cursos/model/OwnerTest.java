package diego.cursos.model;

import diego.cursos.ModelTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


class OwnerTest implements ModelTests {
    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l,"Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("123123123213");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First Name did not Match"),
                        () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City did not match"),
                        () -> assertEquals("123123123213", owner.getTelephone())
                        ));

        assertThat(owner.getCity(),is("Key West"));
    }

    @DisplayName("Value Source Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Diego"})
    void testValueSource(String val) {
        System.out.println(val);
    }
}