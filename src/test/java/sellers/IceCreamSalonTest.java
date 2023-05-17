package sellers;

import eatables.Cone;
import eatables.IceRocket;
import eatables.Magnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamSalonTest {

    private PriceList priceList;
    private IceCreamSalon iceCreamSalon;

    @BeforeEach
    void setIceCreamSalon () {
        priceList = new PriceList(4,4,4);
        iceCreamSalon = new IceCreamSalon(priceList);
    }
    @DisplayName(value = "IceCreamSalon was created")
    @Test
    void printResultIfIceCreamSalonWasCreated() {
        IceCreamSalon iceCreamSalon1 = new IceCreamSalon(new PriceList(4,4,4));
        System.out.println(iceCreamSalon1 + "was created");
    }

    @DisplayName(value = "Test order Cone")
    @Test
    void shouldReturnEqualsIfOrderConeWorksWithGetProfit(){
        double a = 3.0;
        iceCreamSalon.orderCone(new Cone.Flavor [] {Cone.Flavor.STRAWBERRY, Cone.Flavor.VANILLA, Cone.Flavor.PISTACHE});

        double test = iceCreamSalon.getProfit();
        assertEquals(a, test);
    }

    @DisplayName(value = "Test order IceRocket")
    @Test
    void shouldReturnEqualsIfOrderIceRocketWorksWithGetProfit(){
       double a = 0.8;
       iceCreamSalon.orderIceRocket();

       double test = iceCreamSalon.getProfit();
       assertEquals(a, test);
    }

    @DisplayName(value = "Test order Magnum")
    @Test
    void shouldReturnEqualsIfOrderMagnumWorksWithGetProfit(){
        double a = 0.055999999999999994;
        iceCreamSalon.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE);

        double test = iceCreamSalon.getProfit();
        System.out.println(test);
        assertEquals(a, test);
    }

    @DisplayName(value = "Method toString is correct")
    @Test
    void shouldReturnEqualsIfMethodToStringIsCorrect() {
        String example = "IceCreamSalon{Prijslijst{ballPrice=4.0, rocketPrice=4.0, magnumStandartPrice=4.0}, totalProfit=0.0}";
        String actual = iceCreamSalon.toString();

        assertEquals(actual, example);
    }

    @DisplayName(value = "Order Magnum + IceRocket")
    @ParameterizedTest
    @EnumSource(Magnum.MagnumType.class)
    void shouldReturnEqualIfProfitIsZeroWhenPriceIsZeroTestWithMagnumAndIceRocket(Magnum.MagnumType magnumType) {
        IceCreamSalon iceCreamSalon1 = new IceCreamSalon
                (new PriceList(0,0,0));

        iceCreamSalon1.orderMagnum(magnumType);
        iceCreamSalon1.orderIceRocket();

        double test = iceCreamSalon1.getProfit();

        assertEquals(0.0, test);
    }

    @DisplayName(value = "Order Cone + IceRocket")
    @ParameterizedTest
    @EnumSource(Cone.Flavor.class)
    void shouldReturnEqualIfProfitIsZeroWhenPriceIsZeroTestWithConeAndIceRocket(Cone.Flavor flavor) {
        IceCreamSalon iceCreamSalon1 = new IceCreamSalon
                (new PriceList(0,0,0));

        iceCreamSalon1.orderCone(new Cone.Flavor[]{flavor});
        iceCreamSalon1.orderIceRocket();

        double test = iceCreamSalon1.getProfit();

        assertEquals(0.0, test);
    }

    @DisplayName(value = "Return NotNull if price != 0 and order methods works")
    @Test
    void shouldReturnNotNullIfPriceIsNotZeroAndOrderMethodsWorks() {
        IceCreamSalon iceCreamSalon1 = new IceCreamSalon
                (new PriceList(4,5,6));

        iceCreamSalon1.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE);
        iceCreamSalon1.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.VANILLA});
        iceCreamSalon1.orderIceRocket();

        Double test = iceCreamSalon1.getProfit();

        assertNotNull(test);
    }
}