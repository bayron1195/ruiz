package com.usa.misiontic.masterclass3.repository;


import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.repository.crudRepository.ReservasCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservasCrudRepository reservasCrudRepository;
    public List<Reservation> getAll(){
        return (List<Reservation>) reservasCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservasCrudRepository.findById(id);
    }
    public Reservation save(Reservation p){
        return reservasCrudRepository.save(p);
    }
    public void delete(Reservation p){
        reservasCrudRepository.delete(p);
    }

}
