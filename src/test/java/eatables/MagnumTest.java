package eatables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.*;

import static eatables.Magnum.MagnumType.*;
import static org.junit.jupiter.api.Assertions.*;

class MagnumTest {
    private Magnum magnumType;

    @BeforeEach
    void setMagnum (){
        magnumType = new Magnum(BLACKCHOCOLATE);
    }

    @DisplayName(value = "Magnum was created")
    @Test
    void printResultsIfMagnumWasCreated() {
        Magnum magnum1 = new Magnum();
        System.out.println(magnum1 + " was created");

        Magnum magnum2 = new Magnum(Magnum.MagnumType.MILKCHOCOLATE);
        System.out.println(magnum2 + " was created");
    }

    @DisplayName(value = "Eat() works")
    @Test
    void printResultIfMethodEatWorksCorrect() {
        magnumType.eat();
    }

    @DisplayName(value = "Constructor != null")
    @ParameterizedTest
    @EnumSource(Magnum.MagnumType.class)
    void shouldReturnNotNullIfConstructorIsNotNull(Magnum.MagnumType magnumType) {
        assertNotNull(magnumType, "Constructor is null");
    }

    @DisplayName(value = "MagnumType (setter and getter) is Correct")
    @Test
    void shouldReturnEqualsIfSetterMagnumIsCorrect() {
        Magnum magnum1 = new Magnum(BLACKCHOCOLATE);
        assertEquals(magnum1.getType(), magnumType.getType());
    }
}