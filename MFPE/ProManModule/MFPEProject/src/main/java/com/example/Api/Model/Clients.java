package com.example.Api.Model;



import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@Data
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
@Entity

public class Clients {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@ApiModelProperty(value="client id will be auto generated")
	private int clientId;
	
	private String name;
	
	private String POC_FullName;
	
	private String POC_PhoneNumber;
	
	private String POC_EmailAddress;

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPOC_FullName() {
		return POC_FullName;
	}

	public void setPOC_FullName(String pOC_FullName) {
		POC_FullName = pOC_FullName;
	}

	public String getPOC_PhoneNumber() {
		return POC_PhoneNumber;
	}

	public void setPOC_PhoneNumber(String pOC_PhoneNumber) {
		POC_PhoneNumber = pOC_PhoneNumber;
	}

	public String getPOC_EmailAddress() {
		return POC_EmailAddress;
	}

	public void setPOC_EmailAddress(String pOC_EmailAddress) {
		POC_EmailAddress = pOC_EmailAddress;
	}
	
	

}
