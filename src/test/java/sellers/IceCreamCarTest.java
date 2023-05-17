package sellers;

import eatables.Cone;
import eatables.Magnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamCarTest {

    private IceCreamCar iceCreamCar;
    private Stock stock;
    private PriceList priceList;

    @BeforeEach
    void setIceCreamCar() {
        stock = new Stock(5, 5, 5, 5);
        priceList = new PriceList(5, 5, 5);
        iceCreamCar = new IceCreamCar(priceList, stock);
    }

    @DisplayName(value = "No more IceRockets in stock")
    @Test
    void shouldReturnNullIfNoMoreIceRocketsInStock() {
        iceCreamCar = new IceCreamCar(priceList, new Stock(0, 5, 5, 5));
        assertNull(iceCreamCar.orderIceRocket());
    }

    @DisplayName(value = "No more Cones in stock")
    @Test
    void shouldReturnNullIfNoMoreConesInStock() {
        iceCreamCar = new IceCreamCar(priceList, new Stock(5, 0, 5, 5));
        assertNull(iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA}));
    }

    @DisplayName(value = "No more Balls in stock")
    @Test
    void shouldReturnNullIfNoMoreBallsInStock() {
        iceCreamCar = new IceCreamCar(priceList, new Stock(5, 5, 0, 5));
        assertNull(iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA}));
    }

    @DisplayName(value = "No more Magni in stock")
    @Test
    void shouldReturnNullIfNoMoreMagniInStock() {
        iceCreamCar = new IceCreamCar(priceList, new Stock(5, 5, 5, 0));
        assertNull(iceCreamCar.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE));
    }

    @DisplayName(value = "Should return correct amount of IceRocket after order")
    @Test
    void shouldReturnEqualsIfAmountOfIceRocketsIsCorrectAfterOrder() {
        //NOW IceRockets = 5 (See stock)
        iceCreamCar.orderIceRocket();
        //IceRockets -1

        Stock testStock = new Stock(4, 5, 5, 5);
        assertEquals(stock, testStock);
    }

    @DisplayName(value = "Should return correct amount of Cones after order")
    @Test
    void shouldReturnEqualsIfAmountOfConesIsCorrectAfterOrder() {
        //NOW Cones = 5, Balls = 5 (See stock)
        iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.PISTACHE});
        //Cones -1
        //Balls -1

        Stock testStock = new Stock(5, 4, 4, 5);
        assertEquals(stock, testStock);
    }
    @DisplayName(value = "Should return correct amount of Magnum after order")
    @Test
    void shouldReturnEqualsIfAmountOfMagnumIsCorrectAfterOrder() {
        //NOW Magni = 5
        iceCreamCar.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE);
        //Magni -1

        Stock testStock = new Stock(5, 5, 5, 4);
        assertEquals(stock, testStock);
    }

    @DisplayName(value = "If there were no orders, the profit should be zero")
    @Test
    void shouldReturnEqualsIfThereWereNoOrdersTheProfitShouldBeZero() {
        double startProfit = iceCreamCar.getProfit();
        assertEquals(0.0, startProfit);
    }
}