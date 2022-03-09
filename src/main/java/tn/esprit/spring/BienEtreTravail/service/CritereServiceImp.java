package tn.esprit.spring.BienEtreTravail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.BienEtreTravail.entities.Critere;
import tn.esprit.spring.BienEtreTravail.repository.CritereRepository;

/**
 * Critere service
 */

@Service
public class CritereServiceImp  implements CritereService{
	
	/**
	 * Critere Repository
	 */
	@Autowired
	private CritereRepository  critereRepostitory ;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Critere getCritereById(Long id) {
	
		return critereRepostitory.findById(id).get();
				}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Critere> getAllCriteres() {
		 
		return (List<Critere>) critereRepostitory.findAll();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Critere saveCritere(Critere Critere) {
		 
		return critereRepostitory.save(Critere);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Critere updateCritere(Long id, Critere Critere) {
		 Critere.setId(id);
		return critereRepostitory.save(Critere);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteCritereById(Long id) {
		critereRepostitory.deleteById(id);
		
	}
	
	
}
