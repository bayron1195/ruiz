package com.usa.misiontic.masterclass3.repository.crudRepository;

import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.entities.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    @Query("SELECT c.client,COUNT(c.client)  FROM Reservation AS c group by c.client order by COUNT(c.client )DESC")
    public List<Object[]>getTopClients();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date d1, Date d2);
    public List<Reservation>findAllByStatus(String sts);

}
