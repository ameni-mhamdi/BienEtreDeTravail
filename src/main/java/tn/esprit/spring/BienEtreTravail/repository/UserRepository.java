package tn.esprit.spring.BienEtreTravail.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.BienEtreTravail.entities.User;

/**
 * User Data Access Object
 */
@Repository
public interface UserRepository  extends CrudRepository<User, Long>{
 
	//public User findByTypeUser(UserType a);
}
