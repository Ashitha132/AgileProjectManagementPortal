package com.example.Api.Service;

import java.util.List;

import com.example.Api.Model.Projects;

public interface IProjectsService {
List<Projects> getProjects();
String insertProject(Projects projects) throws Exception;
String updateProject(int id,Projects projects) throws Exception;
}
