import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Client } from '../client';
import { ClientService } from '../client.service';
import { Project } from '../project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit{

  project:Project=new Project();
  client:Client=new Client();
  clients!: Client[];
  createProjectForm!: FormGroup;

  constructor(private clientService:ClientService,
    private projectService:ProjectService,
    private router:Router

    ){
      this.createProjectForm = new FormGroup({
        title: new FormControl('', [Validators.required, Validators.minLength(3)]),
        startDate: new FormControl('', [Validators.required]),
        
        status: new FormControl('', [Validators.required]),
       
        expectedEndDate: new FormControl('', [Validators.required]),
        clientId:new FormControl('', [Validators.required]),
        budget: new FormControl('', [Validators.required, Validators.pattern('^[0-9]+$')]),
       });


    }

  ngOnInit(): void {
    this.getClients();
    
  }
  private getClients(){
    this.clientService.getClientList().subscribe(data=>{
      this.clients=data;
     
    });
  }

saveProject(){
  this.projectService.createProject(this.project).subscribe(data =>{
    console.log(data);
  
    

  },
  error=>alert(error.error.text) );
  
  
}



  onSubmit(){
  
    if (this.createProjectForm.valid){
      if(this.project.startDate<this.project.expectedEndDate)
      this.saveProject();
      else
      alert("ExpectedEndDate must be greater than start date");
    }
    else {

      alert("Validation failed!!\nCheck these\na.Title must be minimum 3 characters long\nb.ExpectedEndDate must be greater than start date\nc.Budget should be number\nd.All fields should be filled.");
    }
   

  }

}
