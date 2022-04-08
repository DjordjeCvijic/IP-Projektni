import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConst } from 'src/app/app_const';
import { LocalStorageService } from 'src/app/global-services/local-storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient,private localStorageService:LocalStorageService) { }


  public login(username:String,password:String){
    const body={
      username:username,
      password:password
    }

    return this.http.post<any>(AppConst.API_ENDPOINT+"/auth/login",body);
  }
  

 public singUp(firstName:string,lastName:string,username:string,email:string,password:string){
    const body = { 
      firstName: firstName,
      lastName:lastName,
      email:email,
      username:username,
      password:password
    };
    
   return this.http.post<any>('http://localhost:1123/auth/registration',body);
   
  }
  public logOut(){

    var token=this.localStorageService.getUserTokenFromLocalStorage();
    console.log("token1: ",token);
    this.http.post<any>(AppConst.API_ENDPOINT+"/auth/log-out",token).subscribe({});
    localStorage.removeItem(AppConst.TOKEN_STORAGE_KEY);
    localStorage.removeItem(AppConst.USER_ROLE_STORAGE_KEY);
     token=this.localStorageService.getUserTokenFromLocalStorage();
    console.log("token2: ",token);

  }

  

}