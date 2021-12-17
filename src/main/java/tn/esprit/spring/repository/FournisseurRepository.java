package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Fournisseur;
@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
	@Query(value="SELECT count(`sp_id_produit`),fournisseur.first_name "
			+ "FROM `produit_fournisseures` inner join fournisseur on "
			+ "produit_fournisseures.fournisseures_id_fournisseur="
			+ "fournisseur.id_fournisseur GROUP BY fournisseur.first_name"
			,nativeQuery=true)
	List<Object[]>GetNbProductsbySupplier();
	@Query(value="SELECT SUBSTRING(f.adresse,length(SUBSTRING_INDEX(f.adresse,',', 3))+2 "
			+ ",length(f.adresse)-length(SUBSTRING_INDEX(f.adresse,',', 3))+2) "
			+ ",count(f.idFournisseur)  from Fournisseur f GROUP by "
			+ "SUBSTRING(f.adresse,length(SUBSTRING_INDEX(f.adresse,',', 3))+2 "
			+ ",length(f.adresse)-length(SUBSTRING_INDEX(f.adresse,',', 3))+2) ")
	List<Object[]> countsuppliersbycountry();
	//@Query("SELECT f FROM Fournisseur f WHERE f.Name= :msg")
		@Query("select f from Fournisseur f where f.firstName like %:msg% OR f.lastName like %:msg% OR f.email like %:msg% OR f.phone like %:msg%  OR f.adresse like %:msg%  ")

		public List<Fournisseur> getFournisseurByName(@Param("msg") String msg);

}
