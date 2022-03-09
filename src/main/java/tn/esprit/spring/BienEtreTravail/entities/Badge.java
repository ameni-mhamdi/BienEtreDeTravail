package tn.esprit.spring.BienEtreTravail.entities;

import java.io.Serializable;
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

@Entity
@Table(name = "BADGE")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Badge implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 3453965369444836064L;
	
	/**
	 * Badgeid 
	 */
	
	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Lob
 	@Column(name = "IMAGE")
	private byte[]  image;
	
	

    
    /**
   	 * User
   	 */
       
    @ManyToOne
    @JoinColumn(name="user")
   	private User user;
       
	
   
	

}
