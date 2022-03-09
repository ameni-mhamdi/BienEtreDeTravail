package tn.esprit.spring.BienEtreTravail.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.BienEtreTravail.entities.Critere;
import tn.esprit.spring.BienEtreTravail.entities.Evaluation;
import tn.esprit.spring.BienEtreTravail.entities.User;


public interface EvaluationService {
	/**
	 * Get Evaluation by ID
	 * @param id
	 * @return
	 */
	public  Evaluation getEvaluationById(Long id);
	
	/**
	 * Get all Evaluation 
	 * @return
	 */

	public List<Evaluation> getAllEvaluations();
	
	/**
	 * Get save Evaluation 
	 * @return
	 */

	public Evaluation saveEvaluation(List<Critere> criteres,long id);
	
	
	/**
	 * delete Evaluation by id
	 * @param id
	 * @return
	 */

	public void deleteEvaluationById(Long id);

	

      /**
   	 * update Evaluation by id
   	 * @param id 
   	 * @return
   	 */

       public List<Evaluation> getEvaluationParcritereAndAgetdate(Date date1, Date dat2,Long idA);
    


       /**
    	 * update Evaluation by id
    	 * @param id 
    	 * @return
    	 */

        public List<Evaluation> getEvaluationParUser(Long idA);
       
        
        
}

