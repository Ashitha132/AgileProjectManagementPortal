package com.example.Api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Api.Model.Clients;
import com.example.Api.Repository.ClientsRepository;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	private ClientsRepository clientsRepository;
	
	@Override
	public List<Clients> getClients() {
		// TODO Auto-generated method stub
		return clientsRepository.findAll();
	}

}
