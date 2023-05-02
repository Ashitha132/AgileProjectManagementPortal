import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from './project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
;
  private baseURL="http://localhost:9090/api/projects";
  private baseURL2="http://localhost:9090/api/projects/new";

  constructor(private httpClient:HttpClient) { }
  
  getProjectList():Observable<Project[]>{
    return this.httpClient.get<Project[]>(`${this.baseURL}`);
  }

createProject(project:Project):Observable<Object>{
  return this.httpClient.post(`${this.baseURL2}`,project);
}


updateProject(projectCode:number,data:any):Observable<Project>{
  return this.httpClient.put<Project>(`http://localhost:9090/api/projects/${projectCode}/update`,data);
}


}
