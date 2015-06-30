package com.rootnextsolution.newjurassicpark.model;

import javax.persistence.*;

/**
 * Created by tahmid.tanzim on 6/30/15.
 */
@Entity
public class Dinosaur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    private Integer id;
    @Column(nullable = false)
    private String name;
    @ManyToOne(targetEntity = Cage.class)
    private Cage cage;
    @ManyToOne(targetEntity = Species.class, optional = false)
    private Species species;

    public Dinosaur() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) throws Exception{
        if(cage.getPowerStatus() == PowerStatus.DOWN){
            throw new Exception("Sorry! This cage is power DOWN.");
        }
        if(cage.getMaximumCapacity() <= cage.getDinosaurContained()){
            throw new Exception("Sorry! Cage cannot contain more than " + cage.getMaximumCapacity() + " dinosaurs.");
        }
        if(cage.getDinosaurs().size() > 0 && (cage.getDinosaurs().get(0).getSpecies().getDinosaurType() == DinosaurType.Carnivores || this.species.getDinosaurType() == DinosaurType.Carnivores)){
            if(cage.getDinosaurs().get(0).species != this.species){
                throw new Exception("Sorry! Dinosaur species doesnot match.");
            }
        }
        this.cage = cage;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }    
}