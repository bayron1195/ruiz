package com.usa.misiontic.masterclass3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    private String Client;
    private Date startDate;
    private Date devolutionDate;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("reservation")
    private Category category;


    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"reservation","messages"})
    private Client client;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"reservation","messages"})
    private Audience audience;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer id) {
        this.idReservation = id;
    }



    public String getClient() {
        return Client;
    }

    public void setClient(String client) {
        this.Client = client;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
