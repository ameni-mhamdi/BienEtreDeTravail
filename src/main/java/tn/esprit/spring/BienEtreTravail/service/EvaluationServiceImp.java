package tn.esprit.spring.BienEtreTravail.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.BienEtreTravail.entities.Critere;
import tn.esprit.spring.BienEtreTravail.entities.Evaluation;
import tn.esprit.spring.BienEtreTravail.entities.User;
import tn.esprit.spring.BienEtreTravail.repository.CritereRepository;
import tn.esprit.spring.BienEtreTravail.repository.EvaluationRepository;
import tn.esprit.spring.BienEtreTravail.repository.UserRepository;


/**
 * Evaluation service
 */

@Service
public class EvaluationServiceImp  implements EvaluationService{
	
	/**
	 * Evaluation Repository
	 */
	@Autowired
	private EvaluationRepository  evaluationRepostitory ;
	
	/**
	 * user Repository
	 */
	@Autowired
	private UserRepository userRepository ;
	
	
	/**
	 * Evaluation Repository
	 */
	@Autowired
	private CritereRepository critereRepository ;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Evaluation getEvaluationById(Long id) {
	
		return evaluationRepostitory.findById(id).get();
				}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Evaluation> getAllEvaluations() {
		 
		return (List<Evaluation>) evaluationRepostitory.findAll();
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteEvaluationById(Long id) {
		evaluationRepostitory.deleteById(id);
		
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public List<Evaluation> getEvaluationParcritereAndAgetdate(Date date1, Date dat2, Long idA) {
		return evaluationRepostitory.findAllByDateIsBetweenAndUserId(date1, dat2, idA);
	}
	@Override
	public Evaluation saveEvaluation(List<Critere> criteres, long id) {
	User user=userRepository.findById(id).get();
		Evaluation evaluation=new Evaluation();
		evaluation.setCritere(criteres);
		evaluation.setDate(new Date());;
		evaluation.setUser(user);
		evaluation=evaluationRepostitory.save(evaluation);
		
		for(Critere c:criteres) {
			//c.setEvaluation(evaluation);
			c=critereRepository.save(c);
			user.setPoint(user.getPoint()+c.getNote());
	
		}
		user.setId(id);
		user=userRepository.save(user);
		return evaluation;
	}
	
	@Override
	public List<Evaluation> getEvaluationParUser(Long idA) {
		return evaluationRepostitory.findByUserId(idA);
		
	}
	
		

	
	
	
	
}
