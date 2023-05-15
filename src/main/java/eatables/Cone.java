package eatables;

import java.util.Arrays;

public class Cone implements Eatable {

    private Flavor [] balls;
    public Cone() {
    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    @Override
    public void eat() {

        if (this.balls != null) {
            System.out.println("You're eating cone: " + Arrays.toString(this.balls) + " ");
        }
    }

    public enum Flavor {
        STRAWBERRY,
        BANANA,
        CHOCOLATE,
        VANILLA,
        LEMON,
        STRACIATELLA,
        MOKKA,
        PISTACHE;

    }

    @Override
    public String toString() {
        return "Cone{" +
                "balls=" + Arrays.toString(balls) +
                '}';
    }
}