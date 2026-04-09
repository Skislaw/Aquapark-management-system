package org.example.Buyable;

import org.example.User;

public class Aquapark extends Services implements Purchasable {


    public Aquapark() {
        this.price = 15.00;
        this.availableSpots = 90;
    }

    @Override
    public void start(User user) {
        availableSpots--;
    }

    @Override
    public void finish(User user) {
        availableSpots++;
    }
}
