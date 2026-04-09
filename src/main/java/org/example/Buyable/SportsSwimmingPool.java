package org.example.Buyable;

import lombok.Getter;
import lombok.Setter;
import org.example.User;


@Getter
@Setter
public class SportsSwimmingPool extends Services implements Purchasable {

    public SportsSwimmingPool() {
        this.price = 20;
        this.availableSpots = 120;
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