package tn.esprit.spring.BienEtreTravail.controle;



import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

import tn.esprit.spring.BienEtreTravail.entities.Critere;
import tn.esprit.spring.BienEtreTravail.entities.Evaluation;
import tn.esprit.spring.BienEtreTravail.entities.EvaluationModel;
import tn.esprit.spring.BienEtreTravail.entities.User;
import tn.esprit.spring.BienEtreTravail.repository.UserRepository;
import tn.esprit.spring.BienEtreTravail.service.CritereServiceImp;
import tn.esprit.spring.BienEtreTravail.service.EvaluationServiceImp;


@RestController
@CrossOrigin
public class EvaluationController {

	/**
	 * evaluation service 
	 */
	
	@Autowired
	private EvaluationServiceImp evaluationService;
	
	 @Autowired
	    private ModelMapper modelMapper;
	
	/**
	 * critere service 
	 */
	
	@Autowired
	private CritereServiceImp critereService;
	
	
	@Autowired
	private UserRepository userRepository;
	

	
	/**
	     * GET  /evaluations/:id : get the "id" Evaluation.
	     *
	     * @param id the id of the Evaluation to retrieve
	     * @return the ResponseEntity with status 200 (OK) and with body the Evaluation, or with status 404 (Not Found)
	     */
	@GetMapping("/evaluations/{id}")
	public ResponseEntity<EvaluationModel> getEvaluationById(@PathVariable long id) {
		Evaluation evaluation = evaluationService.getEvaluationById(id);
		EvaluationModel evaluationModel=modelMapper.map(evaluation, EvaluationModel.class);
		
		return ResponseEntity.status(HttpStatus.OK).body(evaluationModel);
	}
	
	
	/**
	     * GET  /evaluations : get all the Evaluation.
	     *
	     * @return the ResponseEntity with status 200 (OK) and the list of Evaluation in body
	     */

	@GetMapping("/evaluations")
	public ResponseEntity<List<EvaluationModel>> getAllsEvaluations() {
		List<Evaluation> evaluations = evaluationService.getAllEvaluations();
		Type listType = new TypeToken<List<EvaluationModel>>(){}.getType();
		List<EvaluationModel> ev = modelMapper.map(evaluations,listType);
		
		return ResponseEntity.status(HttpStatus.OK).body(ev);
	}
	
	/**
	     * POST /critere/id/evaluations : Create a new evaluation.
	     *@param id the id of the Critere to retrieve
	     *@param evaluation the evaluation to create
	     * @return the ResponseEntity with status 201 (Created) and with body the new evaluation, or with status 400 (Bad Request) if the evaluation has already an ID
	     * @throws URISyntaxException if the Location URI syntax is incorrect
	     */
	
	@PostMapping("evaluations/{id}")
	public String addEvaluation( @RequestBody List<Critere> criteres,@PathVariable long id) {
       Evaluation evaluation =evaluationService.saveEvaluation(criteres, id);
		return "added";
	}

		/**
	     * DELETE  /evaluationes/:id : delete the "id" Evaluation.
	     *
	     * @param id the id of the evaluation to delete
	     * @return the ResponseEntity with status 200 (OK)
	     */
	

	@DeleteMapping("/evaluations/{id}")
	public ResponseEntity<Void> deleteEvaluation(@PathVariable("id") Long id) {
		evaluationService.deleteEvaluationById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
		
	@GetMapping("/classement")
	public Object Classement() {
		
		List<User> users=(List<User>) userRepository.findAll();


		Collections.sort(users, new Comparator<User>() {


			@Override
			public int compare(User o1,User o2) {
 
				return  o2.getPoint().compareTo(o1.getPoint());
			}
		});	
		return users;
		
		
	
	}
	}
