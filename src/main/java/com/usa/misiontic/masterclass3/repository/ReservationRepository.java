package com.usa.misiontic.masterclass3.repository;


import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationsCrudRepository;
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationsCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationsCrudRepository.findById(id);
    }
    public Reservation save(Reservation p){
        return reservationsCrudRepository.save(p);
    }
    public void delete(Reservation p){
        reservationsCrudRepository.delete(p);
    }


    public List<Reservation>getDatesReport(Date inicio,Date fin){
        return reservationsCrudRepository.findAllByStarDateAfterAndStartDateBefore(inicio,fin);

    }

    public List<Reservation>getStatusReport(String sts){
        return  reservationsCrudRepository.findAllByStatus(sts);

    }
    public List<Object[]> getTopClients(){
        return reservationsCrudRepository.getTopClients();
    }


}
