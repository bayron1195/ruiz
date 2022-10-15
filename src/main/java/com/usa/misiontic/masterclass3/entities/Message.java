package com.usa.misiontic.masterclass3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;


    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "clientId")

    @JsonIgnoreProperties({"message","reservations"})
    private Client client;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "audience")

    @JsonIgnoreProperties({"message","reservations"})
    private Audience audience;



    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer id) {
        this.idMessage = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String message) {
        this.messageText = messageText;
    }

}
