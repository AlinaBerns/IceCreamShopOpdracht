package eatables;

public class Magnum implements Eatable {

    private MagnumType type;

    public Magnum() {

    }

    public Magnum(MagnumType type) {
        this.type = type;
    }

    @Override
    public void eat() {

        if (this.type != null) {

            System.out.println("You're eating magnum: " + this.getType().name());
        }

    }

    public MagnumType getType() {
        return type;
    }

    public enum MagnumType {

        MILKCHOCOLATE,
        WHITECHOCOLATE,
        BLACKCHOCOLATE,
        ALPINENUTS,
        ROMANTICSTRAWBERRIES;

    }
}