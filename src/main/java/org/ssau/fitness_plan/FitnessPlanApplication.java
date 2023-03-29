package org.ssau.fitness_plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FitnessPlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitnessPlanApplication.class, args);
    }

}
