package org.example.Buyable;

import org.example.User;

public class Aquapark extends Services implements Purchasable {

    public Aquapark(double price, boolean isAvailable, int time) {
        super(price, isAvailable, time);
    }

    @Override
    public void buy(User user, int time) {

    }
}
