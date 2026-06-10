package org.example;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@Data
@RequiredArgsConstructor
public class ServiceUsage {
    private final UserModel userModel;
    private final ServiceModel serviceModel;
    private final LocalTime startTime;
    private LocalTime finishTime;
    private float finalPrice;
}
