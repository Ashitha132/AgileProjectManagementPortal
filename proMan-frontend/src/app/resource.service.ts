import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Resource } from './resource';

@Injectable({
  providedIn: 'root'
})
export class ResourceService {

  private rURL="http://localhost:9090/api/projects/addresource";
  private baseURL="http://localhost:9090/api/projects/resources";
  constructor(private httpClient:HttpClient) { }

  getResourceList():Observable<Resource[]>{
    return this.httpClient.get<Resource[]>(`${this.baseURL}`);

  }

  createResource(resource:Resource):Observable<Object>{
    return this.httpClient.post(`${this.rURL}`,resource);


  }

  


}
