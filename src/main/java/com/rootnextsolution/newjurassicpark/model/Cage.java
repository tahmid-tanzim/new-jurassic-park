package com.rootnextsolution.newjurassicpark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tahmid.tanzim on 6/30/15.
 */
@Entity
public class Cage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    private Integer id;
    @Column(nullable = false)
    private Integer maximumCapacity;
    @Column(nullable = false)
    private PowerStatus powerStatus;
    @OneToMany(targetEntity = Dinosaur.class, mappedBy = "cage")
    @JsonIgnore
    private List<Dinosaur> dinosaurs;   

    public Cage() {
        dinosaurs = new ArrayList<>();
    }

    public Cage(Integer maximumCapacity, PowerStatus powerStatus) {
        this.maximumCapacity = maximumCapacity;
        this.powerStatus = powerStatus;
        dinosaurs = new ArrayList<Dinosaur>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(Integer maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    @Enumerated(EnumType.STRING)
    public PowerStatus getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(PowerStatus powerStatus) throws Exception{
        if(powerStatus == PowerStatus.DOWN && dinosaurs.size() > 0){
            throw new Exception("Sorry! This Cage contais Dinosaur. Can not power DOWN.");
        }
        this.powerStatus = powerStatus;
    }
    
    public List<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

    public void setDinosaurs(List<Dinosaur> dinosaurs) {
        this.dinosaurs = dinosaurs;
    }
    
   public Integer getDinosaurContained(){
        return dinosaurs.size();
    }    
}