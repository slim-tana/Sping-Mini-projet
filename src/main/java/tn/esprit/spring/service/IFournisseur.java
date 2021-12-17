package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Fournisseur;

public interface IFournisseur {
	List<Fournisseur> retrieveAllFournisseurs();

	Fournisseur addFournisseur(Fournisseur f);

	void deleteFournisseur(Long id);

	Fournisseur updateFournisseur(Fournisseur u,long i);

	Fournisseur retrieveFournisseur(Long id);
	
	List<Object[]>nombreProduitsFournisseur();
	List<Object[]>nombreFournisseurparpays();
	void sendmail(Fournisseur f);
	public List<Fournisseur>  getFournisseurByName(String msg) ;

}
