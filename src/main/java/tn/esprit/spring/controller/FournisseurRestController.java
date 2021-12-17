package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.IFournisseur;;
@RestController

public class FournisseurRestController {
	@Autowired
	IFournisseur forr;
	
	@GetMapping("/retrive-all-forr")
	@CrossOrigin(origins="http://localhost:4200")
	//responseBody objet convertir l json (Serialisation)
	@ResponseBody
	public List<Fournisseur> getFour(){
		List<Fournisseur> four = forr.retrieveAllFournisseurs();
		return four;
	}
	
	//recupérer selon l'id
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/retrive-forr/{forr-id}")
	@ResponseBody
	public Fournisseur retriveClient(@PathVariable("forr-id")Long fournisseurId) {
	return forr.retrieveFournisseur (fournisseurId);
	}


	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/add-forr")
	// ki converti men json lel objet (Deserialisation)
	@ResponseBody

	//RequestBody bch tchouf objet client mwjoud wala le, ken mch mwjoud tzidou si nn update
	public Fournisseur addFournisseur(@RequestBody Fournisseur f)
	{
	Fournisseur fournisseur = forr.addFournisseur(f);
	return fournisseur;
	}

	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping("/remove-fournisseur/{fournisseur-id}")
	@ResponseBody
	public void removefournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
	forr.deleteFournisseur(fournisseurId);
	}


	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping(value="/update-fournisseur/{id}") 
	@ResponseBody
	public void updateProduct(@RequestBody Fournisseur f,@PathVariable("id")Long id) {
		forr.updateFournisseur(f, id);
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/retrive-fn/")
	@ResponseBody
	public List<Object[]> function()
	{
		return forr.nombreProduitsFournisseur();	
	}
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/retrive-fn2/")
	@ResponseBody
	public List<Object[]> function2()
	{
		return forr.nombreFournisseurparpays();	
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/sendmail/{id}")
	public void sendEmail(@PathVariable("id")Long id) {
	Fournisseur f =forr.retrieveFournisseur(id);	
	forr.sendmail(f);
	}
	
	//http://localhost:8090/SpringMVC/servlet/searchAvancee/{name}

  	@GetMapping(value="/searchAvancee/{name}")
  	@ResponseBody
  	public List<Fournisseur> getFournisseurByName(@PathVariable("name") String name) {
  	return forr.getFournisseurByName(name);
}
	
}
