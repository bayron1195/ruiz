package com.usa.misiontic.masterclass3.service;


import com.usa.misiontic.masterclass3.entities.Client;
import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.entities.dto.StatusAccount;
import com.usa.misiontic.masterclass3.entities.dto.TopClients;
import com.usa.misiontic.masterclass3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            if(e.isEmpty()){
                return reservationsRepository.save(p);

            }else{
                return p;
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

                if(p.getStatus()!=null){
                    q.get().setStatus(p.getStatus());
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
    public List<Reservation> getReservationsByPeriod(String dateA,String dateB) {

        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
            ;
        }
        if (a.before(b)) {
            return reservationsRepository.getDatesReport(a, b);
        } else {
            return new ArrayList<Reservation>();
        }
    }
    public StatusAccount getReportByStatus() {
        List<Reservation> completes = reservationsRepository.getStatusReport("completed");
        List<Reservation> cancelled = reservationsRepository.getStatusReport("cancelled");

        StatusAccount resultado = new StatusAccount(completes.size(), cancelled.size());
        return resultado;
    }

    public List<TopClients> getTopclients(){
        List<TopClients> tc=new ArrayList<>();
        List<Object[]> result= reservationsRepository.getTopClients();

        for(int i=0;i<result.size();i++){
            int total=Integer.parseInt(result.get(i)[1].toString());
            Client client= (Client) result.get(i)[0];
            TopClients topClient=new TopClients(total,client);
            tc.add(topClient);
        }
        return tc;
    }
}
