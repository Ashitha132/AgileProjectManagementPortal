import { NgModule } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { BrowserModule } from '@angular/platform-browser';
import{HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { ProjectListComponent } from './project-list/project-list.component';
import { AppRoutingModule } from './app-routing.module';
import { CreateProjectComponent } from './create-project/create-project.component';
import { UpdateProjectComponent } from './update-project/update-project.component';
import { CreateResourceComponent } from './create-resource/create-resource.component';
import { ResourceListComponent } from './resource-list/resource-list.component';


@NgModule({
  declarations: [
    AppComponent,
    ProjectListComponent,
    CreateProjectComponent,
    UpdateProjectComponent,
    CreateResourceComponent,
    ResourceListComponent,
    
    
    
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
    
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
