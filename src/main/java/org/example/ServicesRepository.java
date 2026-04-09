package org.example;

import lombok.Data;
import org.example.Buyable.Aquapark;
import org.example.Buyable.Purchasable;
import org.example.Buyable.SportsSwimmingPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class ServicesRepository {
    //a "database" class storing services data
    private Aquapark aquapark = new Aquapark();
    private SportsSwimmingPool sportsSwimmingPool = new SportsSwimmingPool();
    private List<Purchasable> services = new ArrayList<>();

    private void addServices() {
        services.add(aquapark);
        services.add(sportsSwimmingPool);
    }
}
