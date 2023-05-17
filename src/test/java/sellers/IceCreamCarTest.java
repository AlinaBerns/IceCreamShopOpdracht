package sellers;

import eatables.Cone;
import eatables.Magnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

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
    @ParameterizedTest
    @EnumSource(Cone.Flavor.class)
    void shouldReturnNullIfNoMoreConesInStock(Cone.Flavor flavor) {
        iceCreamCar = new IceCreamCar(priceList, new Stock(5, 0, 5, 5));
        assertNull(iceCreamCar.orderCone(new Cone.Flavor[]{flavor}));
    }

    @DisplayName(value = "No more Balls in stock")
    @ParameterizedTest
    @EnumSource(Cone.Flavor.class)
    void shouldReturnNullIfNoMoreBallsInStock(Cone.Flavor flavor) {
        iceCreamCar = new IceCreamCar(priceList, new Stock(5, 5, 0, 5));
        assertNull(iceCreamCar.orderCone(new Cone.Flavor[]{flavor}));
    }

    @DisplayName(value = "No more Magni in stock")
    @ParameterizedTest
    @EnumSource(Magnum.MagnumType.class)
    void shouldReturnNullIfNoMoreMagniInStock(Magnum.MagnumType magnumType) {
        iceCreamCar = new IceCreamCar(priceList, new Stock(5, 5, 5, 0));
        assertNull(iceCreamCar.orderMagnum(magnumType));
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
    @ParameterizedTest
    @EnumSource(Cone.Flavor.class)
    void shouldReturnEqualsIfAmountOfConesIsCorrectAfterOrder(Cone.Flavor flavor) {
        //NOW Cones = 5, Balls = 5 (See stock)
        iceCreamCar.orderCone(new Cone.Flavor[]{flavor});
        //Cones -1
        //Balls -1

        Stock testStock = new Stock(5, 4, 4, 5);
        assertEquals(stock, testStock);
    }
    @DisplayName(value = "Should return correct amount of Magnum after order")
    @ParameterizedTest
    @EnumSource(Magnum.MagnumType.class)
    void shouldReturnEqualsIfAmountOfMagnumIsCorrectAfterOrder(Magnum.MagnumType magnumType) {
        //NOW Magni = 5
        iceCreamCar.orderMagnum(magnumType);
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
    @DisplayName(value = "The profit is correct after orders")
    @Test
    void shouldReturnEqualsIfTheProfitIsCorrectAfterOrders() {
        double startProfit = iceCreamCar.getProfit();
        assertEquals(0.0, startProfit);

        iceCreamCar.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE);
        iceCreamCar.orderIceRocket();
        iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.PISTACHE});

        double actualProfit = 2.0700000000000003;
        assertEquals(actualProfit, iceCreamCar.getProfit());
    }
}