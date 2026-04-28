package com.company.smarttraffic;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/traffic")
public class SmartTrafficController {

    @GetMapping("/check")
    public String checkViolation(
            @RequestParam String vehicleId,
            @RequestParam double speed,
            @RequestParam boolean emergency
    ) {

        if (!emergency && speed > 80) {

            int fine;

            if (speed > 120)
                fine = 5000;
            else if (speed > 100)
                fine = 2000;
            else
                fine = 500;

            return "Violation detected! Fine = ₹" + fine;
        }

        return "No violation detected.";
    }
}