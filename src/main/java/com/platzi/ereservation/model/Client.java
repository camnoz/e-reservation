package com.platzi.ereservation.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Class that represent the Client table
 * @author Camilo Valenzuela
 *
 */
@Data
@Entity
@Table(name = "client")
@NamedQuery(name="Client.findByIdentification", query="Select c from Client c where c.identification = ?1")
public class Client {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idClient;
	private String name;
	private String lastName;
	private String identification;
	private String address;
	private String phone;
	private String email;
	@OneToMany(mappedBy="client")
	private Set<Reservation> reservation;
	
	
	public Client() {
		//Constructor
	}
}
