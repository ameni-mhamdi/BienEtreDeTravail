package tn.esprit.spring.BienEtreTravail.service;

import java.util.List;

import tn.esprit.spring.BienEtreTravail.entities.Event;
import tn.esprit.spring.BienEtreTravail.entities.Participe;

public interface ParticipeService {
	/**
	 * Post Participe by ID
	 * 
	 * @param id
	 * @return
	 */
	public  Event ParticipeByUser(Long idUser,Long idEvent);
	
}