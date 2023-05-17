package eatables;

import sellers.IceCreamSalon;
import sellers.IceCreamSeller;

public class IceRocket implements Eatable {

    public IceRocket() {

    }


    @Override
    public void eat() {

        System.out.println("You're eating Ice Rocket");

    }
}