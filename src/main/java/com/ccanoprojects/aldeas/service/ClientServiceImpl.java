package com.ccanoprojects.aldeas.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ccanoprojects.aldeas.entity.Client;
import com.ccanoprojects.aldeas.repository.ClientRepository;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	@Qualifier("clientRepository")
	ClientRepository clientRepository;

	@Override
	public Client findContactById(int id) {
		return clientRepository.findById(id);
	}

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client addClient(Client client) {
		client.setCreated(new Timestamp(new Date().getTime()));
		client.setUpdated(new Timestamp(new Date().getTime()));
		client.setStatus(Client.RequestStatus.PENDING);
		return clientRepository.save(client);
	}

}