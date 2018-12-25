package com.ccanoprojects.aldeas.service;

import java.util.List;

import com.ccanoprojects.aldeas.entity.Client;

public interface ClientService {

	public abstract Client findContactById(int id);

	public abstract List<Client> findAll();
	
	public abstract Client addClient(Client client);
}
