package com.example.Api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Api.Model.Projects;
import com.example.Api.Model.Resources;

@Repository
public interface ResourcesRepository extends JpaRepository<Resources,Integer>{
	int countByProjectsAndRole(Projects projects, String role);

}
