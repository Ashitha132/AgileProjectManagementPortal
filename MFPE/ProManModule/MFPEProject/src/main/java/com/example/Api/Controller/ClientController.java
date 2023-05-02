package com.example.Api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Api.Model.Clients;
import com.example.Api.Service.IClientService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/api")
public class ClientController {
	@Autowired
	private IClientService clientService;
	
	@GetMapping("/clients")
	// @ApiOperation(value="getting all clients from database")
	public List<Clients> getClients(){
		return clientService.getClients();
	}
}
