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
    private String name;
    @ManyToOne(targetEntity = Cage.class)
    private Cage cage;
    @ManyToOne(targetEntity = Species.class)
    private Species species;

 	public Dinosaur() {

    }

    public Dinosaur(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public void setCage(Cage cage) {
        this.cage = cage;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }    
}