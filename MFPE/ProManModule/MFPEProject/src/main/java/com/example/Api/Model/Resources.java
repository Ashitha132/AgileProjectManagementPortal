package com.example.Api.Model;

import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class Resources {
	@Id
	
//	@GeneratedValue(generator="system-uuid",strategy = GenerationType.AUTO)//(strategy = GenerationType.AUTO, generator = "sequence_generator")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", columnDefinition = "VARCHAR(36)")
	private String userId;
	
	@NotNull
	@Pattern(regexp="^[A-Za-z]+$")
	private String firstName;
	
	@NotNull
	@Pattern(regexp="^[A-Za-z]{3,}$")
	private String lastName;
	
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@cognizant\\.com$", message = "Invalid email address")  
	private String email;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	private String phoneNumber;
	
	@Pattern(regexp="(?i)^(Developer|Tester)$", message = "Invalid role")
	private String role;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="projectCode")
	private Projects projects;
	

	 @PrePersist
	 public void generateUserId() {
	     String userIdPrefix = this.lastName.substring(0, 2).toUpperCase();
	     String userIdSuffix = String.format("%04d", new Random().nextInt(10000));
	     this.userId = userIdPrefix + userIdSuffix;
	 }


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Projects getProjects() {
		return projects;
	}


	public void setProjects(Projects projects) {
		this.projects = projects;
	}
	 
	 
	
	
}
