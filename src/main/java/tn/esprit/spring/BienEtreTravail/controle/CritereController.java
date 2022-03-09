package tn.esprit.spring.BienEtreTravail.controle;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.spring.BienEtreTravail.entities.Critere;
import tn.esprit.spring.BienEtreTravail.entities.CritereModel;
import tn.esprit.spring.BienEtreTravail.entities.EvaluationModel;
import tn.esprit.spring.BienEtreTravail.service.CritereServiceImp;
import tn.esprit.spring.BienEtreTravail.service.UploadImageService;




@RestController
@CrossOrigin
public class CritereController {

	/**
	 * Critere service 
	 */
	
	@Autowired
	private CritereServiceImp CritereService;
	
	 @Autowired
	    private ModelMapper modelMapper;
	
	
	/**
	 * UploadImage service
	 */
	
	@Autowired
	private UploadImageService uploadImageService;
	

	/**
	     * GET  /Criteres/:id : get the "id" Critere.
	     *
	     * @param id the id of the Critere to retrieve
	     * @return the ResponseEntity with status 200 (OK) and with body the Critere, or with status 404 (Not Found)
	     */
	@GetMapping("/Criteres/{id}")
	public ResponseEntity<Critere> getCritereById(@PathVariable long id) {
		Critere Critere = CritereService.getCritereById(id);
		return ResponseEntity.status(HttpStatus.OK).body(Critere);
	}
	
	/**
	     * GET  /Criteres : get all the Critere.
	     *
	     * @return the ResponseEntity with status 200 (OK) and the list of Critere in body
	     */

	@GetMapping("/Criteres")
	public ResponseEntity<List<CritereModel>> getAllsCriteres() {
		List<Critere> criteres = CritereService.getAllCriteres();
		Type listType = new TypeToken<List<CritereModel>>(){}.getType();
		List<CritereModel> cr = modelMapper.map(criteres,listType);
		
		return ResponseEntity.status(HttpStatus.OK).body(cr);
	}
	

	/**
	     * PUT  /Critere : Updates an existing Critere.
	     *
	     * @param centre the centre to update
	     * @return the ResponseEntity with status 200 (OK) and with body the updated Critere,
	     * or with status 400 (Bad Request) if the Critere is not valid,
	     * or with status 500 (Internal Server Error) if the Critere couldn't be updated
	     * @throws URISyntaxException if the Location URI syntax is incorrect
	     */
	
	@PutMapping("/Criteres/{id}")
	public Object updateCritere(@RequestBody Critere critere,@PathVariable Long id) throws IOException {

		
		critere = CritereService.updateCritere(id, critere);

		   return ResponseEntity.status(HttpStatus.CREATED).body(critere);
	}

	/**
	     * DELETE  /Criterees/:id : delete the "id" Critere.
	     *
	     * @param id the id of the Critere to delete
	     * @return the ResponseEntity with status 200 (OK)
	     */
	
	
	@DeleteMapping("/Criteres/{id}")
	public ResponseEntity<Void> deleteCritere(@PathVariable("id") Long id) {
		CritereService.deleteCritereById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	}
