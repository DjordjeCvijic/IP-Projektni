import { Injectable } from '@angular/core';
import { AppConst } from '../app_const';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {

  constructor() { }

  public saveUserTokenToLocalStorage(token:string){

    localStorage.setItem(AppConst.TOKEN_STORAGE_KEY,token);
  }

  private decodeToken(token:String){
      return atob(token.split('.')[1]);
  }

  public getUserTokenFromLocalStorage(){
    var token=localStorage.getItem(AppConst.TOKEN_STORAGE_KEY);
    
    return token;
  }

  public getUserIdFromToken(){
    var token=this.getUserTokenFromLocalStorage();
    var userId=JSON.parse(this.decodeToken(token!)).userId;
    console.log("logged userId: ",userId);
    return userId;
  }

  public getUserIsAdminFromToken(){
    var token=this.getUserTokenFromLocalStorage();
    var admin=JSON.parse(this.decodeToken(token!)).isAdmin;
    console.log("logged user isAdmin: ",admin);
    return admin;
  }
  public getUsernameFromToken(){
    var token=this.getUserTokenFromLocalStorage();
    var username=JSON.parse(this.decodeToken(token!)).sub;
    console.log("logged userId: ",username);
    return username;
  }
}
