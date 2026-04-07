package org.example.Buyable;

import org.example.User;

public interface Purchasable {
    //An interface for different services
    //All subclasses represent one space on each service

    void buy(User user, int time);
}
