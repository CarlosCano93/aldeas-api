package com.ccanoprojects.aldeas.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccanoprojects.aldeas.entity.Client;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Serializable> {
	public abstract Client findById(int id);

	public abstract List<Client> findAll();
}
