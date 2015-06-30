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
public class Application implements CommandLineRunner {
    @Autowired
    CageRepository cageRepository;
    @Autowired
    DinosaurRepository dinosaurRepository;
    @Autowired
    SpeciesRepository speciesRepository;

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
    
    @Override
    public void run(String... strings) throws Exception {
        if(speciesRepository.count() == 0){
            speciesRepository.save(new Species("Ankylosaurus", DinosaurType.Herbivores));
            speciesRepository.save(new Species("Brachiosaurus", DinosaurType.Herbivores));
            speciesRepository.save(new Species("Megalosaurus", DinosaurType.Carnivores));            
            speciesRepository.save(new Species("Spinosaurus", DinosaurType.Carnivores));
            speciesRepository.save(new Species("Stegosaurus", DinosaurType.Herbivores));
            speciesRepository.save(new Species("Triceratops", DinosaurType.Herbivores));
            speciesRepository.save(new Species("Tyrannosaurus", DinosaurType.Carnivores));
            speciesRepository.save(new Species("Velociraptor", DinosaurType.Carnivores));
        }
    }    
    
}
