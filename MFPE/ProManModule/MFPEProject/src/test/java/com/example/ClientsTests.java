package com.example;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Api.Model.Clients;

@ExtendWith(MockitoExtension.class)
public class ClientsTests {
    @Test
    public void testToString() {
        //Clients clients1 = new Clients(1, "Acme Inc.", "John Smith", "123-456-7890", "john.smith@acme.com");
    	Clients clients = new Clients();
    	clients.setClientId(1);
    	clients.setName("Acme Inc.");
    	clients.setPOC_FullName("John Smith");
    	clients.setPOC_PhoneNumber("123-456-7890");
    	clients.setPOC_EmailAddress("john.smith@acme.com");
        String expected = "Clients(clientId=1,name=Acme Inc.,POC_FullName=John Smith,POC_PhoneNumber=123-456-7890,POC_EmailAddress=john.smith@acme.com)";
        String actual = clients.toString();
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void testSetName() {
        Clients client = new Clients();
        client.setName("John Doe");
        assertEquals("John Doe", client.getName());
    }

    @Test
    public void testSetPOC_FullName() {
        Clients client = new Clients();
        client.setPOC_FullName("Jone Smith");
        assertEquals("Jone Smith", client.getPOC_FullName());
    }
    @Test
    public void testSetPOC_PhoneNumber() {
        Clients client = new Clients();
        client.setPOC_PhoneNumber("8746234791");
        assertEquals("8746234791", client.getPOC_PhoneNumber());
    }
    @Test
    public void testSetPOC_EmailAddress() {
        Clients client = new Clients();
        client.setPOC_EmailAddress("jone@gmail.com");
        assertEquals("jone@gmail.com", client.getPOC_EmailAddress());
    }
}