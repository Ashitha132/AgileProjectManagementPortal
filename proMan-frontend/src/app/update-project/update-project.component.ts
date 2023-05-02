import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Client } from '../client';
import { Project } from '../project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-update-project',
  templateUrl: './update-project.component.html',
  styleUrls: ['./update-project.component.css']
})
export class UpdateProjectComponent implements OnInit{

  id!: any;
  form!: FormGroup;
  projects!:Project[];
  selectedValue!:string;

  private routeSub!: Subscription;
  project :Project=new Project();
  client:Client=new Client();

  constructor(private projectService:ProjectService,
    private route:ActivatedRoute,
    private router:Router,
    private activatedRoute: ActivatedRoute,
    private fb:FormBuilder
    ){
      this.form = new FormGroup({
     
        status: new FormControl('', [Validators.required])
        
    });
    }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      this.id = params['id'];
      console.log(this.id);
    });
    
    this.getProjects();
   
    
    
  }
  private getProjects(){
    this.projectService.getProjectList().subscribe(data=>{
      this.projects=data;
      console.log(this.projects);
     
    });

  }
  
  onSubmit(){

        this.project.budget=0;
        this.project.LastUpdatedOn=new Date();
        this.project.title="";
        this.project.status=this.selectedValue;
        this.project.startDate=new Date();
        this.project.createdOn=new Date();
        this.project.expectedEndDate=new Date();
        this.project.projectCode=1;
        this.project.clients=new Client();
        
        this.projectService.updateProject(this.id,this.project).subscribe(data=>{
          console.log(data);
        },
        error=>console.log(error) );

        if(this.project.status){
          alert("Status updated to "+this.project.status);
          

        }
        else{

          alert("Please select status");
        }
        
        


    
  }

}
