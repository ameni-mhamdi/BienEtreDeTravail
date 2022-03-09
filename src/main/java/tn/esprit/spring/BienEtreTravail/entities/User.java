package tn.esprit.spring.BienEtreTravail.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(	name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String username;

	
	private String email;

	private Integer point;

	
	private String password;
	
	//@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	//private  List<Evaluation>  evaluation;

	//@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	//private  List<Participe>  participe;

   // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    //private  List<Badge>  badge;

}
