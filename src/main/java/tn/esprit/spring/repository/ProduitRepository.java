package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.CategorieProduit;
import tn.esprit.spring.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
	@Query("select p from Produit p order by p.prixUnitaire asc ")
    public List<Produit> listProductNotExpensive();
	
	@Query("select p from Produit p order by p.prixUnitaire desc ")
    public List<Produit> listProductExpensive(); 
	
	
	@Query("SELECT p FROM Produit p WHERE p.Name= :msg")
	public Produit getProductByName(@Param("msg") String msg);

}
