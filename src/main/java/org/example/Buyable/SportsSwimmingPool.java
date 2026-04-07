package org.example.Buyable;

import lombok.Getter;
import lombok.Setter;
import org.example.User;


@Getter
@Setter
public class SportsSwimmingPool extends Services implements Purchasable {

    public SportsSwimmingPool(double price, boolean isAvailable, int time) {
        super(price, isAvailable, time);
    }

    @Override
    public void buy(User user, int time) {

    }
}