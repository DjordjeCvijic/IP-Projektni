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

  public getUserTokenFromLocalStorage(){
    var token=localStorage.getItem(AppConst.TOKEN_STORAGE_KEY);
    
    return token;
  }
  public saveUserRoleToLocalStorage(admin:boolean){
    localStorage.setItem(AppConst.USER_ROLE_STORAGE_KEY,admin?"admin":"user");
  }

  public getUserRoleFromLocalStorage(){
    var role=localStorage.getItem(AppConst.USER_ROLE_STORAGE_KEY);
    
    return role=="admin";
  }
}
