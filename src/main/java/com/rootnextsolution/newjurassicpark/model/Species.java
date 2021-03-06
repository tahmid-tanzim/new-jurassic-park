package com.rootnextsolution.newjurassicpark.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by tahmid.tanzim on 6/30/15.
 */
@Entity
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    private Integer id;
    private String name;
    private DinosaurType dinosaurType;

    public Species(){

    }

    public Species(String name, DinosaurType dinosaurType) {
        this.name = name;
        this.dinosaurType = dinosaurType;
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

    public DinosaurType getDinosaurType() {
        return dinosaurType;
    }

    public void setDinosaurType(DinosaurType dinosaurType) {
        this.dinosaurType = dinosaurType;
    }
}