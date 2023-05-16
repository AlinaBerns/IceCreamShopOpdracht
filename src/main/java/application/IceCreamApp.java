package application;

import eatables.Cone;
import eatables.Eatable;
import eatables.IceRocket;
import eatables.Magnum;
import sellers.IceCreamSalon;
import sellers.IceCreamSeller;
import sellers.PriceList;

import java.util.Arrays;

public class IceCreamApp {

    public static void main(String[] args) {

        //Maak een PriceList instantie aan.

        PriceList priceList = new PriceList(1.0, 1.5,2.0);

        //Maak een IceCreamSaloninstantieaanmet behulp van de pricelist en steek deze in een IceCreamSeller variabele.

        IceCreamSeller seller = new IceCreamSalon(priceList);

        //Bestel enkele ijsjes(order methoden), steek deze in een array van Eatable.

        Cone.Flavor [] flavors = {Cone.Flavor.STRAWBERRY, Cone.Flavor.VANILLA, Cone.Flavor.PISTACHE};

        Magnum magnum = seller.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE);

        Cone cone = seller.orderCone(flavors);

        IceRocket iceRocket = seller.orderIceRocket();

        Eatable[] eatbles = {magnum, cone, iceRocket};

        for (Eatable e:eatbles) {
            e.eat();
        }

        System.out.println("\n***PROFIT: " + seller.getProfit() + "***");

    }

}
