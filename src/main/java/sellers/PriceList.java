package sellers;

import eatables.Magnum;

public class PriceList {

    private double ballPrice;
    private double rocketPrice;
    private double magnumStandartPrice;

    public PriceList() {
    }

    public PriceList(double ballPrice, double rocketPrice, double magnumStandartPrice) {
        this.ballPrice = ballPrice;
        this.rocketPrice = rocketPrice;
        this.magnumStandartPrice = magnumStandartPrice;
    }

    public double getBallPrice() {
        return ballPrice;
    }

    public void setBallPrice(double ballPrice) {
        this.ballPrice = ballPrice;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }

    public void setRocketPrice(double rocketPrice) {
        this.rocketPrice = rocketPrice;
    }

    public double getMagnumPrice(Magnum.MagnumType magnumType) {

        switch (magnumType) {
            case ALPINENUTS:

                return magnumStandartPrice * 1.5;

            case MILKCHOCOLATE:

                return magnumStandartPrice * 1.2;

            case BLACKCHOCOLATE:

                return magnumStandartPrice * 1.3;

            case WHITECHOCOLATE:

                return magnumStandartPrice * 1.4;

            case ROMANTICSTRAWBERRIES:

                return magnumStandartPrice * 1.6;

            default:

                return magnumStandartPrice;
        }
    }

    public double getMagnumStandartPrice() {
        return magnumStandartPrice;
    }

    public void setMagnumStandartPrice(double magnumStandartPrice) {
        this.magnumStandartPrice = magnumStandartPrice;
    }

    @Override
    public String toString() {
        return "Prijslijst{" +
                "ballPrice=" + ballPrice +
                ", rocketPrice=" + rocketPrice +
                ", magnumStandartPrice=" + magnumStandartPrice +
                '}';
    }
}