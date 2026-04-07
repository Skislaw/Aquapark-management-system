package org.example.Buyable;

import org.example.User;

public class Sauna extends Services implements Purchasable {

    public Sauna(double price, boolean isAvailable, int time) {
        super(price, isAvailable, time);
    }

    @Override
    public void buy(User user, int time) {

    }
}
