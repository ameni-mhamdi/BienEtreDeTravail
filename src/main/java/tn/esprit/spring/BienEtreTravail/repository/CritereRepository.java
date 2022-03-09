package tn.esprit.spring.BienEtreTravail.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.BienEtreTravail.entities.Critere;

/**
 * Critere Data Access Object
 */
@Repository
public interface CritereRepository  extends CrudRepository<Critere, Long>{
 
	//public Critere findByTypeCritere(CritereType a);
}
