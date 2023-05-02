package com.example.Api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Api.Model.Projects;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects,Integer>{

}
