package com.example.Api.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Api.Model.Clients;
import com.example.Api.Model.Projects;
import com.example.Api.Repository.ClientsRepository;
import com.example.Api.Repository.ProjectsRepository;

@Service
public class ProjectsService implements IProjectsService {
	@Autowired
	private ProjectsRepository projectsRepository;
	@Autowired
	private ClientsRepository clientsRepository;
	
	@Override
	public List<Projects> getProjects() {
		// TODO Auto-generated method stub
		return projectsRepository.findAll();
	}

	@Override
	public String insertProject(Projects projects) throws Exception {
		if (projects.getClients() == null) {
	        throw new Exception("Client id cannot be null");
	    }
	    Optional<Clients> client = clientsRepository.findById(projects.getClients().getClientId());
	    if (!client.isPresent()) {
	        throw new Exception("Client not found");
	    }
	    projects.setCreatedOn(new Date());
	    projects.setLastUpdatedOn(new Date());
		projectsRepository.save(projects);
		return "Project created.";
	}

	@Override
	public String updateProject(int id, Projects projects) throws Exception{
		
		
		
	
		
		
	    Optional<Projects> existingProject = projectsRepository.findById(id);
	    if (existingProject.isPresent()) {
	        Projects updatedProject = existingProject.get();
	        
	    
	        
	        
	        updatedProject.setStatus(projects.getStatus());
	        updatedProject.setLastUpdatedOn(new Date());
	    
	        projectsRepository.save(updatedProject);
	        return "Project updated successfully";
	    } else {
	        throw new Exception("Project not found!!!");
	}
  }

}
