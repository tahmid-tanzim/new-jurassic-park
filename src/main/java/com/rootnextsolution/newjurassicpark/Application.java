package com.rootnextsolution.newjurassicpark;

import com.rootnextsolution.newjurassicpark.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by tahmid.tanzim on 6/30/15.
 */
@SpringBootApplication
public class Application {
    @Autowired
    CageRepository cageRepository;
    @Autowired
    DinosaurRepository dinosaurRepository;
    @Autowired
    SpeciesRepository speciesRepository;

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}
