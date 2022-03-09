package tn.esprit.spring.BienEtreTravail.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.BienEtreTravail.entities.Badge;

/**
 * Badge Data Access Object
 */
@Repository
public interface BadgeRepository  extends CrudRepository<Badge, Long>{
 
	//public Badge findByTypeBadge(BadgeType a);
}
