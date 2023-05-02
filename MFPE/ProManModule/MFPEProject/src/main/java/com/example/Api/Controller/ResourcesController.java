package com.example.Api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Api.Model.Resources;
import com.example.Api.Service.IResourcesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/api/projects")
public class ResourcesController {
	@Autowired
	private IResourcesService resourceService;
	
	@PostMapping("/addresource")
	public String AddResource(@RequestBody Resources resources) throws Exception {
		return resourceService.AddResource(resources);
	}
	@GetMapping("/resources")
	public List<Resources> getAllResources(){
		return resourceService.getAllResources();
	}
}
