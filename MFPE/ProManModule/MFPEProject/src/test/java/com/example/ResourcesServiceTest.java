package com.example;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Api.Exception.MaximumResourceLimitReachedException;
import com.example.Api.Model.Projects;
import com.example.Api.Model.Resources;
import com.example.Api.Repository.ProjectsRepository;
import com.example.Api.Repository.ResourcesRepository;
import com.example.Api.Service.ResourcesService;

@ExtendWith(MockitoExtension.class)
public class ResourcesServiceTest {

    @Mock
    private ResourcesRepository resourceRepository;
    
    @Mock
    private ProjectsRepository projectsRepository;
    
    @InjectMocks
    private ResourcesService resourcesService;
    
    @Test
    public void testAddResource() throws Exception {
        Resources resource = new Resources();
        resource.setUserId("AA1122");
        Projects project = new Projects();
        project.setProjectCode(1);
        project.setStatus("New");
        resource.setProjects(project);
        when(projectsRepository.findById(project.getProjectCode())).thenReturn(Optional.of(project));
        when(resourceRepository.countByProjectsAndRole(project, "Developer")).thenReturn(10);
        when(resourceRepository.countByProjectsAndRole(project, "Tester")).thenReturn(5);
        
        String result = resourcesService.AddResource(resource);
        assertEquals("Resource added successfully to user id AA1122", result);
    }
    
    @Test
    public void testAddResourceMaximumResourceLimitReachedException() throws Exception {
        Resources resource = new Resources();
        resource.setUserId("AA1122");
        Projects project = new Projects();
        project.setProjectCode(1);
        project.setStatus("New");
        resource.setProjects(project);
        when(projectsRepository.findById(project.getProjectCode())).thenReturn(Optional.of(project));
        when(resourceRepository.countByProjectsAndRole(project, "Developer")).thenReturn(50);
        when(resourceRepository.countByProjectsAndRole(project, "Tester")).thenReturn(10);
        
        try {
            resourcesService.AddResource(resource);
        } catch (MaximumResourceLimitReachedException e) {
            assertEquals("Maximum resource limit reached for this project", e.getMessage());
        }
    }
    
    @Test
    public void testAddResourceProjectCancelled() throws Exception {
        Resources resource = new Resources();
        resource.setUserId("AA1122");
        Projects project = new Projects();
        project.setProjectCode(1);
        project.setStatus("cancelled");
        resource.setProjects(project);
        when(projectsRepository.findById(project.getProjectCode())).thenReturn(Optional.of(project));
        
        try {
            resourcesService.AddResource(resource);
        } catch (Exception e) {
            assertEquals("Cannot add Resource, Project is cancelled!!!", e.getMessage());
        }
    }
    
    @Test
    public void testAddResourceProjectNotFound() throws Exception {
        Resources resource = new Resources();
        resource.setUserId("AA1122");
        Projects project = new Projects();
        project.setProjectCode(1);
        resource.setProjects(project);
        when(projectsRepository.findById(project.getProjectCode())).thenReturn(Optional.empty());
        
        try {
            resourcesService.AddResource(resource);
        } catch (Exception e) {
            assertEquals("Project not found!!!", e.getMessage());
        }
    }
    
    @Test
	public void testGetAllResources() {
		Resources resource1 = new Resources();
		resource1.setUserId("AA1122");
		resource1.setRole("Developer");
		
		Resources resource2 = new Resources();
		resource2.setUserId("AA1155");
		resource2.setRole("Tester");
		
		List<Resources> resourcesList = new ArrayList<>();
		resourcesList.add(resource1);
		resourcesList.add(resource2);
		
		when(resourceRepository.findAll()).thenReturn(resourcesList);
		
		List<Resources> result = resourcesService.getAllResources();
		
		assertEquals(2, result.size());
		assertEquals(resource1.getUserId(), result.get(0).getUserId());
		assertEquals(resource2.getUserId(), result.get(1).getUserId());
		assertEquals(resource1.getRole(), result.get(0).getRole());
		assertEquals(resource2.getRole(), result.get(1).getRole());
	}
    
}
