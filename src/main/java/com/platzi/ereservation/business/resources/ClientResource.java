package com.platzi.ereservation.business.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.ereservation.business.resources.vo.ClientVO;
import com.platzi.ereservation.model.Client;
import com.platzi.ereservation.view.services.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Class to controller the web service
 * @author Camilo Valenzuela
 *
 */

@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientResource {

	private final ClientService clientService;
	
	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@PostMapping
	@ApiOperation(value="Create client", notes="service to create a new client")
	@ApiResponses(value= { @ApiResponse(code=201, message="Successfully created client"),
			@ApiResponse(code=400, message="Request not valid")})
	public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVO){
		Client client = new Client();
		client.setName(clientVO.getName());
		client.setLastName(clientVO.getLastName());
		client.setIdentification(clientVO.getIdentification());
		client.setAddress(clientVO.getAddress());
		client.setPhone(clientVO.getPhone());
		client.setEmail(clientVO.getEmail());
		return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
	}
	
	@PutMapping("/{identification}")
	@ApiOperation(value="Update client", notes="service to update a client")
	@ApiResponses(value= { @ApiResponse(code=201, message="Successfully updated client"),
			@ApiResponse(code=404, message="Client not exist")})
	public ResponseEntity<Client> updateClient(@PathVariable("identification") String identification, ClientVO clientVO){
		
		Client client = this.clientService.findByIdentification(identification);
		if(client != null) {
		client.setName(clientVO.getName());
		client.setLastName(clientVO.getLastName());
		client.setIdentification(clientVO.getIdentification());
		client.setAddress(clientVO.getAddress());
		client.setPhone(clientVO.getPhone());
		client.setEmail(clientVO.getEmail());
		return new ResponseEntity<>(this.clientService.update(client), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{identification}")
	@ApiOperation(value="Delete client", notes="service to delete a new client")
	@ApiResponses(value= { @ApiResponse(code=201, message="Successfully deleted client"),
			@ApiResponse(code=404, message="Client not exist")})
	public void deleteClient(@PathVariable("identification") String identification){
		
		Client client = this.clientService.findByIdentification(identification);
		if(client != null) {
			this.clientService.delete(client);
		}
	}
	
	@GetMapping
	@ApiOperation(value="All clients", notes="service to find all clients")
	@ApiResponses(value= { @ApiResponse(code=201, message="Successfully found all clients"),
			@ApiResponse(code=404, message="Request not valid")})
	public ResponseEntity<List<Client>> findAll(){	
		return ResponseEntity.ok(this.clientService.findAll());
	}
	
	
}
