package com.usa.misiontic.masterclass3.repository;


import com.usa.misiontic.masterclass3.entities.Audience;
import com.usa.misiontic.masterclass3.repository.crudRepository.AudienceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AudienceRepository {
    @Autowired
    private AudienceCrudRepository audienceCrudRepository;

    public List<Audience> getAll(){
        return (List<Audience>) audienceCrudRepository.findAll();
    }

    public Optional<Audience> getLibrary(int id){
        return audienceCrudRepository.findById(id);
    }
    public Audience save(Audience c){
        return audienceCrudRepository.save(c);
    }
    public void delete(Audience c){
        audienceCrudRepository.delete(c);
    }

}
