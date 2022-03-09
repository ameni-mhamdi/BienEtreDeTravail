package tn.esprit.spring.BienEtreTravail.service;

import java.util.List;

import tn.esprit.spring.BienEtreTravail.entities.Badge;

public interface BadgeService {
	/**
	 * Get Badge by ID
	 * 
	 * @param id
	 * @return
	 */
	public  Badge getBadgeById(Long id);
	
	/**
	 * Get all Badge 
	 * 
	 * 
	 * @return
	 */

	public List<Badge> getAllBadges();
	
	/**
	 * Get save Badge 
	 * 
	 * 
	 * @return
	 */

	public Badge saveBadge(Badge  critere);
	
	/**
	 * update Badge by id
	 * @param id
	 * 
	 * @return
	 */

	public Badge updateBadge(Long id, Badge  critere);
	
	/**
	 * delete Badge by id
	 * 
	 * @param id
	 * @return
	 */

	public void deleteBadgeById(Long id);
	
	

	}
