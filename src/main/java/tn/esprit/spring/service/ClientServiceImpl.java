package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository clientRepository;


	@Override
	public List<Client> retrieveAllClients() {
		// TODO Auto-generated method stub
		List<Client> clients = clientRepository.findAll();
		return clients;
	}


	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		clientRepository.save(c);
		return c;
	}


	@Override
	public void deleteClient(Long id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);
	}


	@Override
	public Client updateClient(Client c) {
		// TODO Auto-generated method stub
		return clientRepository.save(c);
	}


	@Override
	public Client retrieveClient(Long id) {
		// TODO Auto-generated method stub
		Client client = clientRepository.findById(id).orElse(null);
		return client;
	}

}
