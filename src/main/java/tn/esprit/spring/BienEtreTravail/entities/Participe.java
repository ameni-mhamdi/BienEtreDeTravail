package tn.esprit.spring.BienEtreTravail.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PARTICIPE")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Participe implements Serializable {

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
   	 * User
   	 */
     
    @ManyToOne
    @JoinColumn(name="event")
   	private Event event;
	

    
    /**
   	 * User
   	 */
     
    @ManyToOne
    @JoinColumn(name="user")
   	private User user;
       
	
   
	

}
