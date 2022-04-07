import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConst } from 'src/app/app_const';
import { LoginCount } from 'src/app/model/login-count.model';

@Injectable({
  providedIn: 'root'
})
export class LoginHistoryService {

  constructor(private http:HttpClient) { }


  getLoginCount(){
    return this.http.get<Array<LoginCount>>(AppConst.API_ENDPOINT+"/login-history");
  }
}
