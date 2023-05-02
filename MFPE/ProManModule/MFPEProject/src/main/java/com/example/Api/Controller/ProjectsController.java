package com.example.Api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Api.Model.Projects;
import com.example.Api.Service.IProjectsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/api/projects")
public class ProjectsController {
	
	@Autowired
	private IProjectsService projectsService;
	@GetMapping
	// @ApiOperation(value="getting all projects from database")
	public List<Projects> getProjects(){
		return projectsService.getProjects();
	}
	
	@PutMapping("/{id}/update")
	// @ApiOperation(value="update project status ")
	public String updateProject (@PathVariable int id,@RequestBody Projects project) throws Exception{
		return projectsService.updateProject(id,project);
	}
	
	@PostMapping("/new")
	// @ApiOperation(value="Insert values to projects")
	public String insertProject(@RequestBody Projects projects) throws Exception{
		return projectsService.insertProject(projects);
	}
}
