package org.example;

import lombok.Data;
import org.example.Buyable.Aquapark;
import org.example.Buyable.Purchasable;
import org.example.Buyable.SportsSwimmingPool;

import java.util.ArrayList;
import java.util.List;

@Data
public class ServicesRepository {
    //a "database" class storing services data

    private final List<Purchasable> purchasableList = new ArrayList<>();
    private final List<Aquapark> aquaparkList = new ArrayList<>();
    private final List<SportsSwimmingPool> sportsSwimmingPoolList = new ArrayList<>();
}
