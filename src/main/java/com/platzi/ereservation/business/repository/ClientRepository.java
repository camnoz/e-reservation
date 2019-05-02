/**
 * 
 */
package com.platzi.ereservation.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.ereservation.model.Client;

/**
 * Interface to define the operation from database
 * @author Camilo Valenzuela
 *
 */
public interface ClientRepository extends JpaRepository<Client, String> {

	/**
	 * Method to find by last name of client
	 * @param lastName
	 * @return
	 */
	public List<Client> findByLastName(String lastName);
	
	
	public Client findByIdentification(String identification);
	
}
