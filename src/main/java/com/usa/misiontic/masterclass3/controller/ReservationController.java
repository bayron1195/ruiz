package com.usa.misiontic.masterclass3.controller;


import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.entities.dto.StatusAccount;
import com.usa.misiontic.masterclass3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/report-status")
    public StatusAccount getByStatus(){
        return reservationsService.getReportByStatus();
    }

}
