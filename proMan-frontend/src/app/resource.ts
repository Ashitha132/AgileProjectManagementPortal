import { Project } from "./project";
export class Resource {
    userId!: string;
    firstName!: string;
    lastName!: string;
    email!: string;
    phoneNumber!: string;
    role!: string;
    public projects!: Project;

}
