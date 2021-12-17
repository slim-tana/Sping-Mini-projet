package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.FactureRepository;

@Service
public class FactureServiceImpl implements FactureService {
	@Autowired
	private FactureRepository factureRepository;


	@Override
	public List<Facture> retrieveAllFactures() {
		// TODO Auto-generated method stub
		List<Facture> facture = (List<Facture>) factureRepository.findAll();
		return facture;
	}


	@Override
	public void cancelFacture(Long id) {
		// TODO Auto-generated method stub
		factureRepository.deleteById(id);
	}


	@Override
	public Facture retrieveFacture(Long id) {
		// TODO Auto-generated method stub
		Facture facture = factureRepository.findById(id).orElse(null);
		return facture;
	}

}
