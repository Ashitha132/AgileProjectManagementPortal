import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project } from '../project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements  OnInit {

  projects!: Project[];

  constructor(private projectService:ProjectService,
    private router:Router
    ){}
  ngOnInit(): void {
  this.getProjects();
    
  }
  private getProjects(){
    this.projectService.getProjectList().subscribe(data => {
      this.projects=data;
      console.log(data);
    })
  }
  updateProject(id:number){
    this.router.navigate(['update-project',id ]);

  }


}
