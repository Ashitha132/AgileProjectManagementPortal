import { NgModule } from "@angular/core";
import { Routes,RouterModule } from "@angular/router";
import { CreateProjectComponent } from "./create-project/create-project.component";
import { CreateResourceComponent } from "./create-resource/create-resource.component";
import { ProjectListComponent } from "./project-list/project-list.component";
import { ResourceListComponent } from "./resource-list/resource-list.component";
import { UpdateProjectComponent } from "./update-project/update-project.component";

const routes:Routes=[
    {path:"projects",component:ProjectListComponent},
    {path:"create-project",component:CreateProjectComponent},
    {path:'',redirectTo:'projects',pathMatch:'full' },
    {path:'update-project/:id',component:UpdateProjectComponent},
    {path:'create-resource',component:CreateResourceComponent},
    {path:'resources',component:ResourceListComponent}
];
@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports:[RouterModule]
})
export class AppRoutingModule{}
