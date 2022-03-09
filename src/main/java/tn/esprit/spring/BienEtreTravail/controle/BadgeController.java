package tn.esprit.spring.BienEtreTravail.controle;

import java.io.IOException;
import java.util.List;

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

import tn.esprit.spring.BienEtreTravail.entities.Badge;
import tn.esprit.spring.BienEtreTravail.service.BadgeServiceImp;
import tn.esprit.spring.BienEtreTravail.service.UploadImageService;




@RestController
@CrossOrigin
public class BadgeController {

	/**
	 * badge service 
	 */
	
	@Autowired
	private BadgeServiceImp badgeService;
	
	/**
	 * UploadImage service
	 */
	
	@Autowired
	private UploadImageService uploadImageService;
	

	/**
	     * GET  /badges/:id : get the "id" Badge.
	     *
	     * @param id the id of the Badge to retrieve
	     * @return the ResponseEntity with status 200 (OK) and with body the Badge, or with status 404 (Not Found)
	     */
	@GetMapping("/badges/{id}")
	public ResponseEntity<Badge> getBadgeById(@PathVariable long id) {
		Badge badge = badgeService.getBadgeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(badge);
	}
	
	/**
	     * GET  /badges : get all the Badge.
	     *
	     * @return the ResponseEntity with status 200 (OK) and the list of Badge in body
	     */

	@GetMapping("/badges")
	public ResponseEntity<List<Badge>> getAllsBadges() {
		List<Badge> badges = badgeService.getAllBadges();
		return ResponseEntity.status(HttpStatus.OK).body(badges);
	}
	
	/**
	     * POST /badges  : Create a new badge.
	     * @return the ResponseEntity with status 201 (Created) and with body the new badge, or with status 400 (Bad Request) if the badge has already an ID
	     * @throws URISyntaxException if the Location URI syntax is incorrect
	     
	 * @throws IOException */
	
	@PostMapping("/badges")
	public String addBadge(@RequestParam("imageFile") MultipartFile file,@RequestParam("badge") String badge) throws IOException {

		Badge badge2 = new ObjectMapper().readValue(badge, Badge.class);
		badge2.setImage(UploadImageService.compressBytes(file.getBytes()));
		badge2 = badgeService.saveBadge(badge2);

		return "added";
	}

	/**
	     * PUT  /badge : Updates an existing Badge.
	     *
	     * @param centre the centre to update
	     * @return the ResponseEntity with status 200 (OK) and with body the updated badge,
	     * or with status 400 (Bad Request) if the badge is not valid,
	     * or with status 500 (Internal Server Error) if the badge couldn't be updated
	     * @throws URISyntaxException if the Location URI syntax is incorrect
	     */
	
	@PutMapping("/badges/{id}")
	public Object updateBadge(@RequestParam("imageFile") MultipartFile file,@RequestParam("badge") String badge,@PathVariable Long id) throws IOException {

		Badge badge2 = new ObjectMapper().readValue(badge, Badge.class);
		badge2.setImage(UploadImageService.compressBytes(file.getBytes()));
		badge2 = badgeService.updateBadge(id, badge2);

		   return ResponseEntity.status(HttpStatus.CREATED).body(badge);
	}

	/**
	     * DELETE  /badgees/:id : delete the "id" Badge.
	     *
	     * @param id the id of the badge to delete
	     * @return the ResponseEntity with status 200 (OK)
	     */
	
	
	@DeleteMapping("/badges/{id}")
	public ResponseEntity<Void> deleteBadge(@PathVariable("id") Long id) {
		badgeService.deleteBadgeById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	}
