package sellers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    private Stock stock;

    @BeforeEach
    void setStock() {
        stock = new Stock(10, 10,10,10);
    }

    @DisplayName(value = "Test of setters and getters (Magni)")
    @Test
    void testSetAndGetFromMagni() {
        int a = 5;
        stock.setMagni(5);

        int value1 = stock.getMagni();

        assertEquals(a, value1);
    }

    @DisplayName(value = "Test of setters and getters (Balls)")
    @Test
    void testSetAndGetFromBalls() {
        int a = 5;
        stock.setBalls(5);

        int value2 = stock.getBalls();
        assertEquals(a, value2);
    }

    @DisplayName(value = "Test of setters and getters (Cones)")
    @Test
    void testSetAndGetFromCones() {
        int a = 5;
        stock.setCones(5);

        int value3 = stock.getCones();
        assertEquals(a, value3);

    }

    @DisplayName(value = "Test of setters and getters (Rockets)")
    @Test
    void testSetAndGetFromIceRockets() {
        int a = 5;
        stock.setIceRockets(5);

        int value4 = stock.getIceRockets();
        assertEquals(a, value4);

    }

    @DisplayName(value = "Constructor is not null")
    @Test
    void shouldReturnNotNullIfConstructorIsNotNull () {
        Stock stock1 = new Stock(5,5,5,5);
        assertNotNull(stock1);
    }

    @DisplayName(value = "Hash Test")
    @Test
    void shouldReturnEqualsIfHashCodeWorks(){
        Stock stock1 = new Stock(1,1,1,1);
        Stock stock2 = new Stock(1,1,1,1);

        assertNotSame(stock1, stock2);
        assertEquals(stock1.hashCode(), stock2.hashCode());
    }
}