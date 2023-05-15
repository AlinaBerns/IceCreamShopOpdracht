package application;

import eatables.Cone;
import eatables.Eatable;
import eatables.Magnum;
import sellers.*;

public class IceCreamAppV2 {

    public static void main(String[] args) {

        PriceList priceList = new PriceList(1.0, 1.5,2.0);

        IceCreamSeller seller = new IceCreamCar(priceList, new Stock(1, 1, 1, 1));


        Eatable[] eatbles = {
                //NO MORE ICEROCKET
                seller.orderIceRocket(),

                seller.orderMagnum(Magnum.MagnumType.ALPINENUTS),
                seller.orderMagnum(Magnum.MagnumType.ALPINENUTS),

                //NO MORE MAGNUM
                seller.orderMagnum(Magnum.MagnumType.ALPINENUTS),


                seller.orderCone(new Cone.Flavor[]{Cone.Flavor.STRAWBERRY, Cone.Flavor.LEMON, Cone.Flavor.STRACIATELLA}),
                seller.orderCone(new Cone.Flavor[]{Cone.Flavor.PISTACHE, Cone.Flavor.VANILLA, Cone.Flavor.CHOCOLATE}),

                //NO MORE FLAVORS
                seller.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA, Cone.Flavor.LEMON, Cone.Flavor.STRACIATELLA}),
        };

        for (Eatable e:eatbles) {
            if(e != null)
                e.eat();
        }

        System.out.println("\n***PROFIT: " + seller.getProfit() + "***");

    }

}