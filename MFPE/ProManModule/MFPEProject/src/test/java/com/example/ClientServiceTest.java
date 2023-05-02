package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Api.Model.Clients;
import com.example.Api.Repository.ClientsRepository;
import com.example.Api.Service.ClientService;


@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
	
	@Mock
    private ClientsRepository clientsRepository;
	
	@InjectMocks
	private ClientService clientsService;
	
	private Clients client1;
	private Clients client2;
	
	@BeforeEach
	public void setUp() {
	    

	        client1= new Clients();
	        client1.setClientId(1);
	        client1.setName("client1");
	        client1.setPOC_FullName("John Sebastin");
	        client1.setPOC_PhoneNumber("8453217964");
	        client1.setPOC_EmailAddress("John@gmail.com");
	        
	        client2= new Clients();
	        client2.setClientId(1);
	        client2.setName("client2");
	        client2.setPOC_FullName("John Sebastin");
	        client2.setPOC_PhoneNumber("8453217964");
	        client2.setPOC_EmailAddress("John Sebastin");

	       
	    }

	
	@Test
    public void testGetProjects() {
		
		when(clientsRepository.findAll()).thenReturn(Arrays.asList(client1,client2));

        // Act
        List<Clients> clients = clientsService.getClients();

        // Assert
        assertThat(clients).isNotNull().contains(client1,client2);

        verify(clientsRepository).findAll();
    }
}