package com.usa.misiontic.masterclass3.repository;

import com.usa.misiontic.masterclass3.entities.Score;

import com.usa.misiontic.masterclass3.repository.crudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ScoreRepository {


    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    public Score save(Score p){
        return scoreCrudRepository.save(p);
    }
    public void delete(Score p){
        scoreCrudRepository.delete(p);
    }
}
