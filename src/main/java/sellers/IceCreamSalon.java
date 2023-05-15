package sellers;

import eatables.Cone;
import eatables.IceRocket;
import eatables.Magnum;

import java.util.Locale;
import java.util.Scanner;

public class IceCreamSalon implements IceCreamSeller{
    private PriceList priceList;
    private double totalProfit;

    public IceCreamSalon(PriceList priceList) {
        this.totalProfit = 0;
        this.priceList = priceList;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        Cone cone = new Cone(flavors);

        totalProfit += priceList.getBallPrice() * flavors.length * 0.25;

        return cone;
    }

    @Override
    public IceRocket orderIceRocket() {
        IceRocket iceRocket = new IceRocket();

        totalProfit += priceList.getRocketPrice() * 0.20;

        return iceRocket;
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) {

        Magnum magnum = new Magnum(magnumType);

        totalProfit += priceList.getMagnumPrice(magnumType) * 0.01;

        return magnum;
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }

    @Override
    public String toString() {
        return "IceCreamSalon{" + this.priceList +
                ", totalProfit=" + this.totalProfit +
                '}';
    }


}