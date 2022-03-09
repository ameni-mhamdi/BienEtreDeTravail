package tn.esprit.spring.BienEtreTravail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.BienEtreTravail.entities.Badge;
import tn.esprit.spring.BienEtreTravail.repository.BadgeRepository;

/**
 * Badge service
 */

@Service
public class BadgeServiceImp  implements BadgeService{
	
	/**
	 * Badge Repository
	 */
	@Autowired
	private BadgeRepository  badgeRepostitory ;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Badge getBadgeById(Long id) {
	
		return badgeRepostitory.findById(id).get();
				}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Badge> getAllBadges() {
		 
		return (List<Badge>) badgeRepostitory.findAll();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Badge saveBadge(Badge Badge) {
		 
		return badgeRepostitory.save(Badge);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Badge updateBadge(Long id, Badge Badge) {
		 Badge.setId(id);
		return badgeRepostitory.save(Badge);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteBadgeById(Long id) {
		badgeRepostitory.deleteById(id);
		
	}
	
	
}
