package eatables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sellers.IceCreamSalon;
import sellers.IceCreamSeller;
import sellers.PriceList;

import static org.junit.jupiter.api.Assertions.*;

class EatableTest {

    private PriceList priceList;
    private IceCreamSeller seller;

    private Magnum magnum;
    private Cone.Flavor [] flavors;

    private Cone cone;

    private IceRocket iceRocket;


    @BeforeEach
    void setup () {
        priceList = new PriceList(1.0, 1.5,2.0);
        seller = new IceCreamSalon(priceList);
        magnum = seller.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE);
        flavors = new Cone.Flavor[]{Cone.Flavor.STRAWBERRY, Cone.Flavor.VANILLA, Cone.Flavor.PISTACHE};
        cone = seller.orderCone(flavors);
        iceRocket = seller.orderIceRocket();

    }

    @Test
    void printResultOfEatIfEatWorksCorrect() {
        Eatable[] eatables = {magnum, cone, iceRocket};
        for (Eatable e:eatables) {
            e.eat();
        }
    }

}