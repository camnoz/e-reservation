package com.platzi.ereservation.business.resources.vo;

import lombok.Data;

/**
 * Class that represent the Client table
 * @author Camilo Valenzuela
 *
 */
@Data
public class ClientVO {
	private String idClient;
	private String name;
	private String lastName;
	private String identification;
	private String address;
	private String phone;
	private String email;
	
	public ClientVO() {
		//Constructor
	}
}
