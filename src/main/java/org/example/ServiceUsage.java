package org.example;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@Data
@RequiredArgsConstructor
public class ServiceUsage {
    private int id;
    private final User user; //user of this particular service
    private final ServiceType serviceType; //defines what type of service it is
    private final LocalTime startTime;
    private LocalTime finishTime;
    private float finalPrice;
}
