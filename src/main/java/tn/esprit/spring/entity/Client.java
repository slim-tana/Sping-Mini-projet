package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@ToString
@Getter
@Setter
public class Client implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name="idClient")
	private Long idClient; // Clé primaire
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String email;
	private String password;
    @Enumerated(EnumType.ORDINAL)
	private CategorieClient categorieClient;
    
    @Enumerated(EnumType.ORDINAL)
	private Profession profession;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Facture> facture;
    

}
