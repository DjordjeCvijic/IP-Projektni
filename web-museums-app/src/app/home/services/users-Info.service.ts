import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConst } from 'src/app/app_const';
import { UsersInfo } from 'src/app/model/users-info.model';

@Injectable({
  providedIn: 'root'
})
export class UsersInfoService {

  constructor(private http:HttpClient) { }


  getLoginCount(){
    return this.http.get<UsersInfo>(AppConst.API_ENDPOINT+"/user-info");
  }
}
