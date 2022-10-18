package com.usa.misiontic.masterclass3.controller;


import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.entities.dto.StatusAccount;
import com.usa.misiontic.masterclass3.entities.dto.TopClients;
import com.usa.misiontic.masterclass3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationsService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationsService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody  Reservation p){
        return reservationsService.save(p);
    }


    @GetMapping("report-dates/2020-01-01/2020-12-31'")
    public List<Reservation> getByDates(@PathVariable("dateA")String da,@PathVariable("dateB")String db ){
        return reservationsService.getReservationsByPeriod(da,db);
    }

    @GetMapping("/report-status")
    public StatusAccount getByStatus(){
        return reservationsService.getReportByStatus();
    }

    @GetMapping("/report-clients")
    public List<TopClients> getTopClients(){
        return reservationsService.getTopclients();
    }

}
