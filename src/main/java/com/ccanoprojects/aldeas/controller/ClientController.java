package com.ccanoprojects.aldeas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccanoprojects.aldeas.entity.Client;
import com.ccanoprojects.aldeas.service.ClientService;
import com.ccanoprojects.aldeas.service.EmailService;

@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired
	private EmailService emailService;

	@Autowired
	@Qualifier("clientService")
	private ClientService clientService;

	@GetMapping("/clients")
	public List<Client> getClients() {
		return clientService.findAll();
	}

	@PostMapping(value = "/clients", consumes = "application/json")
	public Client addClient(@RequestBody Client client) {
		emailService.sendSimpleMessage(client.getEmail(), client.getName(), client.getMessage());
		return clientService.addClient(client);
	}
}
