package eatables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class IceRocketTest {

    private IceRocket iceRocketTest;

    @BeforeEach
    void setIceRocketTest() {
        iceRocketTest = new IceRocket();
    }


    @DisplayName(value = "IceRocket was created")
    @Test
    void printResultsIfIceRocketWasCreated() {
        IceRocket iceRocket = new IceRocket();
        System.out.println(iceRocket + " was created");

    }

    @DisplayName(value = "Eat() works")
    @Test
    void printResultIfMethodEatWorksCorrect() {
        iceRocketTest.eat();
    }

    @DisplayName(value = "Constructor is not null")
    @Test
    void shouldReturnNotNullIfConstructorIsNotNull() {
        iceRocketTest = new IceRocket();
        assertNotNull(iceRocketTest, "Constructor is null");

    }
}