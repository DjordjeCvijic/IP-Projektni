import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConst } from 'src/app/app_const';
import { LocalStorageService } from 'src/app/global-services/local-storage.service';
import { UsersInfo } from 'src/app/model/users-info.model';

@Injectable({
  providedIn: 'root'
})
export class UsersInfoService {

  constructor(private http:HttpClient,
    private localStorageService:LocalStorageService) { }


  getLoginCount(){
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer '+this.localStorageService.getUserTokenFromLocalStorage(),
    }
    );
    return this.http.get<UsersInfo>(AppConst.API_ENDPOINT+"/user-info",{ headers: headers });
  }
}
