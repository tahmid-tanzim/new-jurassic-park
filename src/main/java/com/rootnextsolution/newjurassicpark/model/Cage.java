package com.rootnextsolution.newjurassicpark.model;

import javax.persistence.*;

/**
 * Created by tahmid.tanzim on 6/30/15.
 */
@Entity
public class Cage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    private Integer id;
    private Integer maximumCapacity;
    private PowerStatus powerStatus;

 	public Cage() {

    }

    public Cage(Integer id, Integer maximumCapacity, PowerStatus powerStatus) {
        this.id = id;
        this.maximumCapacity = maximumCapacity;
        this.powerStatus = powerStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getmaximumCapacity() {
        return maximumCapacity;
    }

    public void setmaximumCapacity(Integer maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

	@Enumerated(EnumType.STRING)
    public PowerStatus getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(PowerStatus powerStatus) {
        this.powerStatus = powerStatus;
    }
}