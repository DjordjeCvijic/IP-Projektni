import { LoginCount } from "./login-count.model";

export class UsersInfo{
    activeUsersCount:number;
    registeredUsersCount:number;
    loginCountList:Array<LoginCount>;


    constructor( activeUsersCount:number,
        registeredUsersCount:number,
        loginCountList:Array<LoginCount>){
            this.activeUsersCount=activeUsersCount;
            this.registeredUsersCount=registeredUsersCount;
            this.loginCountList=loginCountList;
        }
}