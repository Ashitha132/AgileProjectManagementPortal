import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Project } from '../project';
import { ProjectService } from '../project.service';
import {Resource} from '../resource';
import { ResourceService } from '../resource.service';

@Component({
  selector: 'app-create-resource',
  templateUrl: './create-resource.component.html',
  styleUrls: ['./create-resource.component.css']
})
export class CreateResourceComponent implements OnInit{

resource:Resource=new Resource();
projects!:Project[];
project:Project=new Project();
createResourceForm!: FormGroup;


constructor(private projectService:ProjectService,
  private resourceService:ResourceService,

  
  ){
    this.createResourceForm = new FormGroup({
      firstName: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]),
      lastName: new FormControl('', [Validators.required, Validators.minLength(3), Validators.pattern('^[a-zA-Z]+$')]),
      email: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z0-9._%+-]+@cognizant.com$')]),
      phoneNumber: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{10}$')]),
      role: new FormControl('', [Validators.required]),
      projectCode: new FormControl('', [Validators.required]),
    });
  }
ngOnInit(): void {
 this.getProjects();
  
}
private getProjects(){
  this.projectService.getProjectList().subscribe(data=>{
    this.projects=data;
    console.log(data);
   
  });

}

saveResource(){
  this.resourceService.createResource(this.resource).subscribe(data=>{
    console.log(data);
  },
  error=>alert(error.error.text) );
  
}

onSubmit(){
  
 
  if (this.createResourceForm.valid){
    this.saveResource();
  
    console.log(this.resource);
    }
    else{
      alert("     Validation Error!!!     \n Resource not Added\nCheck these\na. Phone number should be exactly 10 digits long\nb. Email address should always have @cognizant.com\nc. Firstname and lastname should only have alphabets and last name must be minimum 3 characters long.\nd.No field Should be empty");
    }
    
  
 
 


}
}
