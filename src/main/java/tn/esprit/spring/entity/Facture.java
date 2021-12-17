package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Facture implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name="idFacture")
	private Long idFacture; // Clé primaire
	private float montantRemise;
	private float montantFacture;
	private Date dateFacture;
	private Boolean active;
	@OneToMany(mappedBy="facture")
	private List<DetailFacture> detailFacture;
	@ManyToOne
	private Client client;
}
