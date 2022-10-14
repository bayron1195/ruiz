package com.usa.misiontic.masterclass3.entities;

import jdk.internal.joptsimple.internal.Messages;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String name;
    private Integer age;
    private String password;
    private String email;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private List<Message> message;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private List<Reservas> reservas;



    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }


    public List<Reservas> getreservas() {
        return reservas;
    }

    public void setreservas(List<Reservas> reservas) {
        this.reservas = reservas;
    }
}
