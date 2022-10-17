package com.usa.misiontic.masterclass3.repository.crudRepository;

import com.usa.misiontic.masterclass3.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    public List<Reservation>findAllByStatus(String sts);

}
