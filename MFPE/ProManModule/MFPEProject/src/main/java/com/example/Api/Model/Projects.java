package com.example.Api.Model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.AssertTrue;
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
public class Projects {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="project_code")
private Integer projectCode;

@Column(name="title",nullable=false)
private String title;

@Column(name="budget",nullable=false)
private int budget;

@Column(name="start_date")
@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
private Date startDate;

@Column(name="expected_end_date")
@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyy-MM-dd")
private Date expectedEndDate;

@Column(name="created_on")
@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyy-MM-dd")
private Date createdOn;

@Column(name="status",nullable=false)
@Pattern(regexp="^(?i)(New|InProgress|Completed|Delayed|Cancelled)$", message = "Invalid Status")
private String status;

@Column(name="last_updated_on")
@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyy-MM-dd")
private Date LastUpdatedOn;

@AssertTrue(message = "End date must be after start date")
public boolean isEndDateAfterStartDate() {
    if (startDate == null || expectedEndDate == null) {
        return true; // Ignore validation if either date is null
    }
    return expectedEndDate.after(startDate);
}

@ManyToOne(fetch= FetchType.EAGER)
@JoinColumn(name="client_id")
private Clients clients;

public Integer getProjectCode() {
	return projectCode;
}

public void setProjectCode(Integer projectCode) {
	this.projectCode = projectCode;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public int getBudget() {
	return budget;
}

public void setBudget(int budget) {
	this.budget = budget;
}

public Date getStartDate() {
	return startDate;
}

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

public Date getExpectedEndDate() {
	return expectedEndDate;
}

public void setExpectedEndDate(Date expectedEndDate) {
	this.expectedEndDate = expectedEndDate;
}

public Date getCreatedOn() {
	return createdOn;
}

public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Date getLastUpdatedOn() {
	return LastUpdatedOn;
}

public void setLastUpdatedOn(Date lastUpdatedOn) {
	LastUpdatedOn = lastUpdatedOn;
}

public Clients getClients() {
	return clients;
}

public void setClients(Clients clients) {
	this.clients = clients;
}




}


