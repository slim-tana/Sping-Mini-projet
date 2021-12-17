package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class DetailFacture {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name="idDetailFacture")
	private Long idDetailFacture; // Clé primaire
	private Integer qte;
	private float prixTotal;
	private Integer pourcentageRemise;
	private Integer montantRemise;
	@ManyToOne
	private Produit produit;
	@ManyToOne
	private Facture facture;


	
}
