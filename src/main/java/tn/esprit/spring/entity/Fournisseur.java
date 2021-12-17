package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "Fournisseur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Fournisseur implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFournisseur")
	private Long idFournisseur ; 
	private String firstName;
	private String lastName;
	private String email;
	private Long phone;
	private String adresse;
	@ManyToMany(mappedBy="Fournisseures",fetch=FetchType.LAZY,
			cascade={
					CascadeType.PERSIST,
					CascadeType.MERGE,
					CascadeType.REMOVE
			})
	private Set<Produit>sp=new HashSet<>();
	
	
	
}
