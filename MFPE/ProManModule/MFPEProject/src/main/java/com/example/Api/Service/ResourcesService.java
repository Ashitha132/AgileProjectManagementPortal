package com.example.Api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Api.Exception.MaximumResourceLimitReachedException;
import com.example.Api.Model.Projects;
import com.example.Api.Model.Resources;
import com.example.Api.Repository.ProjectsRepository;
import com.example.Api.Repository.ResourcesRepository;

@Service
public class ResourcesService implements IResourcesService {
	@Autowired
	private ResourcesRepository resourceRepository;
	@Autowired
	private ProjectsRepository projectsRepository;
	
	
	@Override
	public String AddResource(Resources resources) throws Exception {
		
	        

		if (resources.getProjects()==null) {
            throw new Exception("Project cannot be null!!!");
        }
	        Projects projects = resources.getProjects();
	        Optional<Projects> project = projectsRepository.findById(projects.getProjectCode());
	        
	        if (project.isPresent()) {
	            Projects pro = project.get();
	            if (pro.getStatus().equalsIgnoreCase("cancelled")) {
	                throw new Exception("Cannot add Resource, Project is cancelled!!!");
	            }
	            
	            
	          
	            int numDevelopers = resourceRepository.countByProjectsAndRole(pro, "Developer");
	            int numTesters = resourceRepository.countByProjectsAndRole(pro, "Tester");
	            if (numDevelopers >= 50 || numTesters >= 10) {
	                throw new MaximumResourceLimitReachedException("Maximum resource limit reached for this project");
	            }
	        }
	        else {
	        	throw new Exception("Project not found!!!");
	        }
	        resources.setProjects(resources.getProjects());
	        resourceRepository.save(resources);
	        
		
		return "Resource added successfully to user id "+resources.getUserId();
	}


	@Override
	public List<Resources> getAllResources() {
		// TODO Auto-generated method stub
		return resourceRepository.findAll();
	}
	

	}

