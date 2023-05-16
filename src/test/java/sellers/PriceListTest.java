package sellers;

import eatables.Magnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceListTest {

    private PriceList priceList;
    private PriceList priceListWithParam;

    @BeforeEach
    void setPriceList() {
        priceList = new PriceList();
        priceListWithParam = new PriceList(5, 5, 5);
    }

    @DisplayName(value = "Test of setters and getters (BallPrice)")
    @Test
    void testSetAndGetFromBallPrice() {
        double a = 4;
        priceListWithParam.setBallPrice(4);

        double value = priceListWithParam.getBallPrice();
        assertEquals(a, value);
    }

    @DisplayName(value = "Test of setters and getters (RocketPrice)")
    @Test
    void testSetAndGetFromRocketPrice() {
        double a = 4;
        priceListWithParam.setRocketPrice(4);

        double value = priceListWithParam.getRocketPrice();
        assertEquals(a, value);
    }

    @DisplayName(value = "Test of setters and getters (MagnumStandartPrice)")
    @Test
    void testSetAndGetFromMagnumStandartPrice() {
        double a = 4;
        priceListWithParam.setMagnumStandartPrice(4);

        double value = priceListWithParam.getMagnumStandartPrice();
        assertEquals(a, value);
    }

    @DisplayName(value = "Test of getter Magnum price (ALPINENUTS)")
    @Test
    void testGetterMagnumPriceAlpineNuts() {
        double a = 6;
        priceListWithParam.setMagnumStandartPrice(4);

        double value = priceListWithParam.getMagnumPrice(Magnum.MagnumType.ALPINENUTS);
        assertEquals(a, value);
    }

    @DisplayName(value = "Test of getter Magnum price (MILKCHOCOLATE)")
    @Test
    void testGetterMagnumPriceMilkChocolate() {
        double a = 4.8;
        priceListWithParam.setMagnumStandartPrice(4);

        double value = priceListWithParam.getMagnumPrice(Magnum.MagnumType.MILKCHOCOLATE);
        assertEquals(a, value);
    }
    @DisplayName(value = "Test of getter Magnum price (BLACKCHOCOLATE)")
    @Test
    void testGetterMagnumPriceBlackChocolate() {
        double a = 5.2;
        priceListWithParam.setMagnumStandartPrice(4);

        double value = priceListWithParam.getMagnumPrice(Magnum.MagnumType.BLACKCHOCOLATE);
        assertEquals(a, value);
    }

    @DisplayName(value = "Test of getter Magnum price (WHITECHOCOLATE)")
    @Test
    void testGetterMagnumPriceWhiteChocolate() {
        double a = 5.6;
        priceListWithParam.setMagnumStandartPrice(4);

        double value = priceListWithParam.getMagnumPrice(Magnum.MagnumType.WHITECHOCOLATE);
        assertEquals(a, value);
    }
    @DisplayName(value = "Test of getter Magnum price (ROMANTICSTRAWBERRIES)")
    @Test
    void testGetterMagnumPriceRomanticStrawberries() {
        double a = 6.4;
        priceListWithParam.setMagnumStandartPrice(4);

        double value = priceListWithParam.getMagnumPrice(Magnum.MagnumType.ROMANTICSTRAWBERRIES);
        assertEquals(a, value);
    }
    @DisplayName(value = "Constructor is not null")
    @Test
    void shouldReturnNotNullIfConstructorIsNotNull () {
        PriceList priceList1 = new PriceList(4,4,4);
        assertNotNull(priceList1);
    }

    @DisplayName(value = "Method toString is correct")
    @Test
    void shouldReturnEqualsIfMethodToStringIsCorrect(){
        String test = "Prijslijst{ballPrice=5.0, rocketPrice=5.0, magnumStandartPrice=5.0}";
        String actual = priceListWithParam.toString();
        System.out.println(priceListWithParam.toString());
        
        assertEquals(test, actual);
    }
}