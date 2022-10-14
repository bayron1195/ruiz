package com.usa.misiontic.masterclass3.service;

import com.usa.misiontic.masterclass3.entities.Audience;
import com.usa.misiontic.masterclass3.repository.AudienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll(){
        return audienceRepository.getAll();
    }
    public Optional<Audience> getLibrary(int id){
        return audienceRepository.getLibrary(id);
    }
    public Audience save(Audience p){
        if(p.getId()==null){
            return audienceRepository.save(p);
        }else{
            Optional<Audience> e = audienceRepository.getLibrary(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return audienceRepository.save(p);
            }
        }
    }
    public Audience update(Audience p){
        if(p.getId()!=null){
            Optional<Audience> q = audienceRepository.getLibrary(p.getId());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                if(p.getOwner()!=null){
                    q.get().setOwner(p.getOwner());
                }
                if(p.getCategory()!=null){
                    q.get().setCategory(p.getCategory());
                }
                if(p.getCapacity()!=null){
                    q.get().setCapacity(p.getCapacity());
                }


                audienceRepository.save(q.get());
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
        Optional<Audience>p= audienceRepository.getLibrary(id);
        if(p.isPresent()){
            audienceRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}
