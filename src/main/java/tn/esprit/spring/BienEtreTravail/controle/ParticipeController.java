package tn.esprit.spring.BienEtreTravail.controle;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.BienEtreTravail.repository.EventRepository;
import tn.esprit.spring.BienEtreTravail.repository.UserRepository;
import tn.esprit.spring.BienEtreTravail.service.ParticipeServiceImp;


@RestController
@CrossOrigin
@Transactional
public class ParticipeController {

	/**
	 * evaluation service 
	 */
	
	@Autowired
	private ParticipeServiceImp participeService;
	
	
	
	
	
	@PostMapping("participe/{idUser}/user/{idEvent}/event")
	public String addParticipe(@PathVariable long idUser,@PathVariable long idEvent ) {
        	participeService.ParticipeByUser(idUser, idEvent);
		return "added";
	}
}
