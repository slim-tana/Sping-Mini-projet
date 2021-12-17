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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Client;
import tn.esprit.spring.service.ClientService;

@RestController


public class ClientRestController {

	@Autowired

	ClientService clientService;

	// http://localhost:8088/SpringMVC/servlet/retrieve-all-clients
	@CrossOrigin("*")

	@GetMapping("/retrieve-all-clients")

	@ResponseBody

	public List<Client> getClients() {

		List<Client> listClients = clientService.retrieveAllClients();

		return listClients;

	}


	//http://localhost:8088/SpringMVC/servlet/retrieve-client/111
	@CrossOrigin("*")

	@GetMapping("/retrieve-client/{client-id}")
	@ResponseBody
	public Client retrieveClient(@PathVariable("client-id") Long idClient) {
		return clientService.retrieveClient(idClient);
	}
	// http://localhost:8088/SpringMVC/servlet/add-client
	@CrossOrigin("*")

	@PostMapping("/add-client")

	@ResponseBody

	public Client addClient(@RequestBody Client c)

	{

		Client client = clientService.addClient(c);

		return client;

	}


	// http://localhost:8088/SpringMVC/servlet/remove-client/{client-id}
	@CrossOrigin("*")

	@DeleteMapping("/remove-client/{client-id}")

	@ResponseBody

	public void removeClient(@PathVariable("client-id") Long idClient) {

		clientService.deleteClient(idClient);

	}

	// http://localhost:8088/SpringMVC/servlet/modify-client
	@CrossOrigin("*")

	@PutMapping("/modify-client")

	@ResponseBody

	public Client modifyClient(@RequestBody Client client) {

		return clientService.updateClient(client);

	}


}
