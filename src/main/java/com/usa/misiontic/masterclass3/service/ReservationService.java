package com.usa.misiontic.masterclass3.service;


import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationsRepository;

    public List<Reservation> getAll(){
        return reservationsRepository.getAll();
    }
    public Optional<Reservation> getProduct(int id){
        return reservationsRepository.getReservation(id);
    }
    public Reservation save(Reservation p){
        if(p.getIdReservation()==null){
            return reservationsRepository.save(p);
        }else{
            Optional<Reservation> e = reservationsRepository.getReservation(p.getIdReservation());
            if(e.isPresent()){
                return p;
            }else{
                return reservationsRepository.save(p);
            }
        }
    }
    public Reservation update(Reservation p){
        if(p.getIdReservation()!=null){
            Optional<Reservation> q = reservationsRepository.getReservation(p.getIdReservation());
            if(q.isPresent()){
                if(p.getIdReservation()!=null){
                    q.get().setIdReservation(p.getIdReservation());
                }

                if(p.getClient()!=null){
                    q.get().setClient(p.getClient());
                }
                if(p.getStartDate()!=null){
                    q.get().setStartDate(p.getStartDate());
                }
                if(p.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(p.getDevolutionDate());
                }
                reservationsRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation>p= reservationsRepository.getReservation(id);
        if(p.isPresent()){
            reservationsRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}
