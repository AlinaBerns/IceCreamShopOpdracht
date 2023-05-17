package sellers;

import eatables.Cone;
import eatables.IceRocket;
import eatables.Magnum;

public class IceCreamCar implements IceCreamSeller {
    private PriceList pricelist;
    private double profit;
    private Stock stock;

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.pricelist = priceList;
        this.stock = stock;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {

        Cone cone = prepareCone(flavors);

        if (cone != null) {

            profit += pricelist.getBallPrice() * flavors.length * 0.25;

        }
        return cone;
    }

    private Cone prepareCone(Cone.Flavor[] flavors) {

        if (stock.getCones() <= 0 || stock.getBalls() <= 0 || flavors.length > stock.getBalls()) {
            System.out.println("NO MORE CONES");

            return null;

        } else {
            stock.setCones(stock.getCones() - 1);
            stock.setBalls(stock.getBalls() - flavors.length);

        }
        return new Cone(flavors);
    }


    @Override
    public IceRocket orderIceRocket() {
        IceRocket iceRocket = prepareRocket();

        if (iceRocket != null) {

            profit += pricelist.getRocketPrice() * 0.15;

        }
        return iceRocket;
    }

    private IceRocket prepareRocket() {

        if (stock.getIceRockets() <= 0) {

            System.out.println("NO MORE ICEROCKET");
            return null;

        } else {
            stock.setIceRockets(stock.getIceRockets() - 1);

        }
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) {
        Magnum magnum = prepareMagnum(magnumType);

        if (magnum != null) {
            profit += pricelist.getMagnumPrice(magnumType) * 0.01;
        }
        return magnum;
    }

    private Magnum prepareMagnum(Magnum.MagnumType magnumType) {

        if (stock.getMagni() <= 0) {
            System.out.println("NO MORE MAGNUM");

            return null;

        } else {
            stock.setMagni(stock.getMagni() - 1);
        }
        return new Magnum(magnumType);
    }


    @Override
    public double getProfit() {
        return profit;
    }

}