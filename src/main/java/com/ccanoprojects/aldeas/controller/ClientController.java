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
@RequestMapping("/api/clients")
public class ClientController {

	@Autowired
	@Qualifier("clientService")
	private ClientService clientService;

	@GetMapping("/get")
	public List<Client> getClient() {
		return clientService.findAll();
	}

	@PostMapping(value = "/add", consumes = "application/json")
	public Client addClient(@RequestBody Client client) {
		return clientService.addClient(client);
	}
}
