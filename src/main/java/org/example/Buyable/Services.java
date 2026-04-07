package org.example.Buyable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Services {
    private double price;
    private boolean isAvailable;
    private int time;
}
