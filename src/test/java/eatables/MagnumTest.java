package eatables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagnumTest {
    private Magnum magnumType;

    @BeforeEach
    void setMagnum (){
        magnumType = new Magnum(Magnum.MagnumType.BLACKCHOCOLATE);
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

    @DisplayName(value = "Constructor is not null")
    @Test
    void shouldReturnNotNullIfConstructorIsNotNull() {
        magnumType = new Magnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);
        assertNotNull(magnumType, "Constructor is null");

    }

}