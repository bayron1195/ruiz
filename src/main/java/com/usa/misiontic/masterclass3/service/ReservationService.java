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
import java.util.List;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationsRepository;

    public List<Reservation> getAll(){
        return reservationsRepository.getAll();
    }

    public Reservation save(Reservation r){
        return reservationsRepository.save(r);
    }

    public List<Reservation> getReservationsByPeriod(String dateA,String dateB){

        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date f= new Date();
        Date g= new Date();
        try {
            f=parser.parse(dateA);
            g=parser.parse(dateB);
        }catch (ParseException e){
            e.printStackTrace();;
        }
        if(f.before(g)){
            return reservationsRepository.getDatesReport((java.sql.Date) f, (java.sql.Date) g);
        }else{
            return new ArrayList<Reservation>();
        }
    }

    public StatusAccount getReportByStatus(){
        List<Reservation> completes=reservationsRepository.getStatusReport("completed");
        List<Reservation> cancelled=reservationsRepository.getStatusReport("cancelled");

        StatusAccount resultado=new StatusAccount(completes.size(),cancelled.size());
        return resultado;
    }

    public List<TopClients>getTopclients(){
    List<TopClients>tc=new ArrayList<>();
    List<Object[]>result=reservationsRepository.getTopClients();

    for (int i=0;i<result.size();i++){
        int total=Integer.parseInt(result.get(i)[1].toString());
        Client client= (Client) result.get(i)[0];
        TopClients topClient=new TopClients(total,client);
        tc.add(topClient);
        }

        return tc;
    }



}
