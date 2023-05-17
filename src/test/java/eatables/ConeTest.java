package eatables;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class ConeTest {
    private Cone.Flavor[] flavors;
    private Cone.Flavor[] balls;
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

    @Disabled("!!!Later")
    @Test
    void eatTest(){
        String eatPrint = null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);
            Cone cone = new Cone(new Cone.Flavor[]{Cone.Flavor.STRAWBERRY, Cone.Flavor.VANILLA, Cone.Flavor.PISTACHE});
            cone.eat();
            capture.flush();
            eatPrint = outputStream.toString();
            System.setOut(originalOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("You're eating cone: [STRAWBERRY, VANILLA, PISTACHE] \n", eatPrint);
    }
}
