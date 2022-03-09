package tn.esprit.spring.BienEtreTravail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.BienEtreTravail.entities.Event;
import tn.esprit.spring.BienEtreTravail.entities.Participe;
import tn.esprit.spring.BienEtreTravail.entities.User;
import tn.esprit.spring.BienEtreTravail.repository.EventRepository;
import tn.esprit.spring.BienEtreTravail.repository.ParticipeRepository;
import tn.esprit.spring.BienEtreTravail.repository.UserRepository;

/**
 * Participe service
 */

@Service
public class ParticipeServiceImp  implements ParticipeService{
	
	/**
	 * Participe Repository
	 */
	@Autowired
	private ParticipeRepository  critereRepostitory ;
	@Autowired
	private EventRepository  eventRepostitory ;
	@Autowired
	private ParticipeRepository  participeRepostitory ;


	/**
	 * user Repository
	 */
	@Autowired
	private UserRepository userRepository ;

	@Override
	public Event ParticipeByUser(Long idUser, Long idEvent) {
	Participe participe=new Participe();
	User user=userRepository.findById(idUser).get();
	Event event=eventRepostitory.findById(idEvent).get();
	user.setPoint(user.getPoint()+event.getNote());
	user.setId(user.getId());
	user=userRepository.save(user);
	participe.setEvent(event);
	participe.setUser(user);
	participe=participeRepostitory.save(participe);
	
	
	
     
		return null;
	}
	}
