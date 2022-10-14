package com.usa.misiontic.masterclass3.repository;


import com.usa.misiontic.masterclass3.entities.Message;
import com.usa.misiontic.masterclass3.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    public Message save(Message p){
        return messageCrudRepository.save(p);
    }
    public void delete(Message p){
        messageCrudRepository.delete(p);
    }

}
