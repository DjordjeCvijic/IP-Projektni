import { Injectable } from '@angular/core';
import { AppConst } from '../app_const';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {

  constructor() { }

  public saveUserTokenToLocalStorage(token:string){
    // console.log(atob(token.split('.')[1]))
    // var decodedToken=atob(token.split('.')[1]);
    // console.log("vrijednost je ",JSON.parse(decodedToken).userId);
    localStorage.setItem(AppConst.TOKEN_STORAGE_KEY,token);
  }

  private decodeToken(token:String){
      return atob(token.split('.')[1]);
  }

  public getUserTokenFromLocalStorage(){
    var token=localStorage.getItem(AppConst.TOKEN_STORAGE_KEY);
    
    return token;
  }
  // private saveUserRoleToLocalStorage(admin:boolean){
  //   localStorage.setItem(AppConst.USER_ROLE_STORAGE_KEY,admin?"admin":"user");
  // }

  // private getUserRoleFromLocalStorage(){
  //   var role=localStorage.getItem(AppConst.USER_ROLE_STORAGE_KEY);    
  //   return role=="admin";
  // }

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
}
