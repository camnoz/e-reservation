/**
 * 
 */
package com.platzi.ereservation.view.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.ereservation.business.repository.ClientRepository;
import com.platzi.ereservation.model.Client;

/**
 * Class to define the services to client
 * @author Camilo Valenzuela
 *
 */
@Service
@Transactional(readOnly = true)
public class ClientService {

	private final ClientRepository clientRepository;
	
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	/**
	 * Method to create a client
	 * @param client
	 * @return
	 */
	@Transactional
	public Client create(Client client) {
		return this.clientRepository.save(client);
	}
	
	/**
	 * Method to update a client
	 * @param client
	 * @return
	 */
	@Transactional
	public Client update(Client client) {
		return this.clientRepository.save(client);
	}
	
	/**
	 * Method to delete a client
	 * @param client
	 */
	@Transactional
	public void delete(Client client) {
		this.clientRepository.delete(client);
	}
	
	/**
	 * Method to find a client by identification
	 * @param identification
	 * @return
	 */
	
	public Client findByIdentification(String identification) {
		return this.clientRepository.findByIdentification(identification);
	}

	public List<Client> findAll() {
		return this.clientRepository.findAll();
	}
}
