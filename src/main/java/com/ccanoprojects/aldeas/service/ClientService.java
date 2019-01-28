package com.ccanoprojects.aldeas.service;

import java.util.List;

import com.ccanoprojects.aldeas.entity.Client;

public interface ClientService {

	/**
	 * Find and return a client by ID
	 * @param id Client
	 * @return #Client
	 */
	public abstract Client findContactById(int id);

	/**
	 * Find all clients without filters
	 * @return List of #Client
	 */
	public abstract List<Client> findAll();
	
	/**
	 * Save client
	 * @param client #Client
	 * @return #Client saved
	 */
	public abstract Client addClient(Client client);
}
