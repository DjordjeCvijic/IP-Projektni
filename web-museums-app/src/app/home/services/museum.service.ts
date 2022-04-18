import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConst } from 'src/app/app_const';
import { LocalStorageService } from 'src/app/global-services/local-storage.service';
import { MuseumWithVirtualTours } from 'src/app/model/museum-with-virtual-tours.mode';
import { Museum } from 'src/app/model/museum.model';

@Injectable({
  providedIn: 'root'
})
export class MuseumService {

  constructor(private http:HttpClient,private localStorageService:LocalStorageService) { }

  public getAllMuseums(){

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer '+this.localStorageService.getUserTokenFromLocalStorage(),
    }
    );
    return this.http.get<Array<Museum>>(AppConst.API_ENDPOINT+"/museum/get-all",{ headers: headers });
  }

  public getMuseumWithVirtualTour(museumId:number){
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer '+this.localStorageService.getUserTokenFromLocalStorage(),
    })
    return this.http.get<MuseumWithVirtualTours>(AppConst.API_ENDPOINT+"/museum?museumId="+museumId+"&userId="+this.localStorageService.getUserIdFromToken(),{ headers: headers });
  }
}
