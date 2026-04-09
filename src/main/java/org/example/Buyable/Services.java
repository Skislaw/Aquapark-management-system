package org.example.Buyable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Services {
    protected double price;
    protected int availableSpots;
}
