package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class DetailProduit implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name="idDetailProduit")
	private Long idDetailProduit; // Clé primaire
	private Date dateCreation;
	private Date dateDerniereModification;
    @Enumerated(EnumType.ORDINAL)
	private CategorieProduit categorieProduit;
    @OneToOne(mappedBy="detailProduit")
    private Produit produit;
}
