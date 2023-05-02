package com.example;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Api.Model.Clients;
import com.example.Api.Model.Projects;
import com.example.Api.Repository.ClientsRepository;
import com.example.Api.Repository.ProjectsRepository;
import com.example.Api.Service.ProjectsService;

@ExtendWith(MockitoExtension.class)
public class ProjectsServiceTest {

    @Mock
    private ProjectsRepository projectsRepository;

    @Mock
    private ClientsRepository clientsRepository;

    @InjectMocks
    private ProjectsService projectsService;

    @Test
    public void testGetProjects() {
        List<Projects> expectedProjects = new ArrayList<>();
        expectedProjects.add(new Projects());
        expectedProjects.add(new Projects());

        when(projectsRepository.findAll()).thenReturn(expectedProjects);

        List<Projects> actualProjects = projectsService.getProjects();

        assertEquals(expectedProjects, actualProjects);
    }

    @Test
    public void testInsertProject() throws Exception {
        Clients client = new Clients();
        client.setClientId(1);

        Projects project = new Projects();
        project.setProjectCode(1);
        project.setTitle("Project 1");
        project.setBudget(1000);
        project.setStartDate(new Date());
        project.setExpectedEndDate(new Date());
        project.setClients(client);

        when(clientsRepository.findById(1)).thenReturn(Optional.of(client));
        when(projectsRepository.save(project)).thenReturn(project);

        String expectedMessage = "Project created.";
        String actualMessage = projectsService.insertProject(project);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testUpdateProject() throws Exception {
        Clients client = new Clients();
        client.setClientId(1);

        Projects existingProject = new Projects();
        existingProject.setProjectCode(1);
        existingProject.setTitle("Project 1");
        existingProject.setBudget(1000);
        existingProject.setStartDate(new Date());
        existingProject.setExpectedEndDate(new Date());
        existingProject.setClients(client);

        Projects updatedProject = new Projects();
        updatedProject.setProjectCode(1);
        updatedProject.setTitle("Project 1 Updated");
        updatedProject.setBudget(2000);
        updatedProject.setStartDate(new Date());
        updatedProject.setExpectedEndDate(new Date());
        updatedProject.setClients(client);

        when(projectsRepository.findById(1)).thenReturn(Optional.of(existingProject));
        when(clientsRepository.findById(1)).thenReturn(Optional.of(client));
        when(projectsRepository.save(existingProject)).thenReturn(updatedProject);

        String expectedMessage = "Project updated successfully";
        String actualMessage = projectsService.updateProject(1, updatedProject);

        assertEquals(expectedMessage, actualMessage);
        assertEquals("Project 1 Updated", existingProject.getTitle());
        assertEquals(2000.0, existingProject.getBudget(), 0.0);
    }
}
