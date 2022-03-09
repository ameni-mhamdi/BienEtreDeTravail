package tn.esprit.spring.BienEtreTravail.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.BienEtreTravail.entities.Participe;

/**
 * Participe Data Access Object
 */
@Repository
public interface ParticipeRepository  extends CrudRepository<Participe, Long>{
 
}