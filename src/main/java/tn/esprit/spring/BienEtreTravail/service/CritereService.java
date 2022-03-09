package tn.esprit.spring.BienEtreTravail.service;

import java.util.List;

import tn.esprit.spring.BienEtreTravail.entities.Critere;

public interface CritereService {
	/**
	 * Get Critere by ID
	 * 
	 * @param id
	 * @return
	 */
	public  Critere getCritereById(Long id);
	
	/**
	 * Get all Critere 
	 * 
	 * 
	 * @return
	 */

	public List<Critere> getAllCriteres();
	
	/**
	 * Get save Critere 
	 * 
	 * 
	 * @return
	 */

	public Critere saveCritere(Critere  critere);
	
	/**
	 * update Critere by id
	 * @param id
	 * 
	 * @return
	 */

	public Critere updateCritere(Long id, Critere  critere);
	
	/**
	 * delete Critere by id
	 * 
	 * @param id
	 * @return
	 */

	public void deleteCritereById(Long id);
	
	

	}
