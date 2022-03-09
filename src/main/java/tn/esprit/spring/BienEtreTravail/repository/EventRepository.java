package tn.esprit.spring.BienEtreTravail.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.BienEtreTravail.entities.Event;

/**
 * Event Data Access Object
 */
@Repository
public interface EventRepository  extends CrudRepository<Event, Long>{
 
	//public Event findByTypeEvent(EventType a);
}
