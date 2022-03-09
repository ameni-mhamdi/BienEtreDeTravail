package tn.esprit.spring.BienEtreTravail.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.BienEtreTravail.entities.Evaluation;


/**
 * Evaluation Data Access Object
 */
@Repository
public interface EvaluationRepository  extends CrudRepository<Evaluation, Long>{
	
	public List<Evaluation> findAllByDateIsBetweenAndUserId(Date date1, Date dat2,Long idA);
	public List<Evaluation> findByUserId(Long id);


}
