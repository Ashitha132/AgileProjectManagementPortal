import {Client} from './client';

export class Project {
    projectCode!: number;
    title!: string;
    budget!: number;
    startDate!: Date;
    expectedEndDate!: Date;
    createdOn!: Date;
    status!: string;
    LastUpdatedOn!: Date;
    public clients!: Client;


}
