package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.StockRepository;
import tn.esprit.spring.entity.CategorieProduit;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Stock;

@Service
public class ProduitServiceImpl  implements ProduitService{

	@Autowired
	private ProduitRepository ProductRepository;	

	@Autowired
	private StockRepository StockRepository;	
	public String addProduct(Produit p) {

		ProductRepository.save(p);
		return "product added successfuly";
	
		
	}
		@Override
	public void deleteProduct(long i) {

		ProductRepository.deleteById(i);
	}

	@Override
	public List<Produit> retrieveAllProducts() {
		List<Produit> produits = (List<Produit>) ProductRepository.findAll();	
		return produits;
	}

	@Override
	public String updateProduct(Produit p) {
		
		ProductRepository.save(p);
		return "product updated successfuly";
		
	}

	@Override
	public List<Produit> listProductNotExpensive() {
		List<Produit> products = (List<Produit>) ProductRepository.listProductNotExpensive();	
		return products;
	}

	

	@Override
	public Produit getProductByName(String msg) {
		return ProductRepository.getProductByName(msg);
	}

	@Override
	public List<Produit> listProductExpensive() {
		List<Produit> products = (List<Produit>) ProductRepository.listProductExpensive();	
		return products;
	}

		@Override
		public Iterable<Produit> findAll() {
			return ProductRepository.findAll();
		}
	
		}

