import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from './client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private cURL="http://localhost:9090/api/clients";

  constructor(private httpClient:HttpClient) { }

  getClientList():Observable<Client[]>{
    return this.httpClient.get<Client[]>(`${this.cURL}`);
  }
}
