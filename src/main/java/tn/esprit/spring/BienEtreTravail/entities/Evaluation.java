package tn.esprit.spring.BienEtreTravail.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "EVALUATION")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Evaluation implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 3453965369444836064L;
	
	/**
	 * evaluation id
	 */

	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	/**
	 * evaluation user
	 */
	
	
    @ManyToOne
	private  User user;
	

	
	/**
	 * evaluation Date
	 */
	
	@Column(name = "DATE")
	private Date date;
	
	
	 
	 /**
	 * Critere evaluation
	 */
		
	@OneToMany(mappedBy = "evaluation", cascade = CascadeType.ALL)
	private  List<Critere>  critere;
		


}
