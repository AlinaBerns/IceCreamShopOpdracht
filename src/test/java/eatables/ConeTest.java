package eatables;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class ConeTest {
    private Cone.Flavor[] flavors;
    @BeforeEach
    void setCone() {
        flavors = new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.VANILLA, Cone.Flavor.PISTACHE};
    }

    @DisplayName(value = "Cone is not empty")
    @Test
    void shouldReturnEqualsIfConeIsNotEmpty() {
        flavors = new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.VANILLA, Cone.Flavor.PISTACHE};
        Cone.Flavor[] flavorsTest = new Cone.Flavor[] {};
        assertNotEquals(flavors, flavorsTest);
    }
    @DisplayName(value = "Constructor is not null")
    @Test
    void shouldReturnNotNullIfConstructorIsNotNull () {
        Cone.Flavor [] cone = new Cone.Flavor [] {Cone.Flavor.BANANA, Cone.Flavor.VANILLA, Cone.Flavor.PISTACHE};
        assertNotNull(cone, "Constructor is null");
    }
    @DisplayName(value = "Method toString is correct")
    @Test
    void shouldReturnEqualsIfMethodToStringIsCorrect() {
        String expected = "[BANANA, VANILLA, PISTACHE]";
        String actual = Arrays.toString(flavors);
        assertEquals(expected, actual);
    }
    @DisplayName(value = "Cone was created")
    @Test
    void printResultsIfConeWasCreated() {
        Cone cone = new Cone();
        System.out.println(cone + " was created");

        Cone cone1 = new Cone(Cone.Flavor.values());
        System.out.println(cone1 + " was created");
    }
}
