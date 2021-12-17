package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Stock implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name="idStock")
	private Long idStock; // Clé primaire
	private Integer qteStock;
	private Integer qteMin;
	private String libelleStock;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Produit> produit;
	
	 public Long getIdStock() {
	        return idStock;
	    }

	    public void setIdStock(Long idStock) {
	        this.idStock = idStock;
	    }

	    public Integer getQte() {
	        return qteStock;
	    }

	    public void setQte(Integer qte) {
	        this.qteStock = qte;
	    }

	    public Integer getQteMin() {
	        return qteMin;
	    }

	    public void setQteMin(Integer qteMin) {
	        this.qteMin = qteMin;
	    }

	    public String getLibelleStock() {
	        return libelleStock;
	    }

	    public void setLibelleStock(String libelleStock) {
	        this.libelleStock = libelleStock;
	    }
}
