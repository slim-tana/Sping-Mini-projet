package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Produit;



public interface ProduitService {
	public 	String addProduct(Produit p);
	public Iterable<Produit> findAll();

	public List<Produit> retrieveAllProducts();
	
	public String updateProduct(Produit p);	
	
	public List<Produit> listProductNotExpensive();
	
	public List<Produit> listProductExpensive();


	
	public Produit getProductByName( String msg);


	

	void deleteProduct(long i);
}
