import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConst } from 'src/app/app_const';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) { }


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
    const body=this.getUserTokenFromLocalStorage();
    console.log("token ",body);
    this.http.post<any>(AppConst.API_ENDPOINT+"/auth/log-out",body).subscribe({});
    localStorage.removeItem(AppConst.TOKEN_STORAGE_KEY);
    console.log("token ",body);
  }

  public saveUserTokenToLocalStorage(token:string){
    localStorage.setItem(AppConst.TOKEN_STORAGE_KEY,token);
  }

  public getUserTokenFromLocalStorage(){
    var token=localStorage.getItem(AppConst.TOKEN_STORAGE_KEY);
    
    return token;
  }

}