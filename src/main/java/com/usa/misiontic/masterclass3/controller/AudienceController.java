package com.usa.misiontic.masterclass3.controller;


import com.usa.misiontic.masterclass3.entities.Audience;
import com.usa.misiontic.masterclass3.entities.Category;
import com.usa.misiontic.masterclass3.service.AudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Audience")
public class AudienceController {

    @Autowired
    private AudienceService audienceService;

    @GetMapping("/all")
    public List<Audience> getAll(){
        return audienceService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience save(@RequestBody Audience p){
        return audienceService.save(p);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience update (@RequestBody  Audience p){
        return audienceService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){

        return audienceService.delete(id);
    }
}
