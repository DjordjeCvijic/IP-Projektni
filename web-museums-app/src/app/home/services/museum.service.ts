import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConst } from 'src/app/app_const';
import { MuseumWithVirtualTours } from 'src/app/model/museum-with-virtual-tours.mode';
import { Museum } from 'src/app/model/museum.model';

@Injectable({
  providedIn: 'root'
})
export class MuseumService {

  constructor(private http:HttpClient) { }

  public getAllMuseums(){
    return this.http.get<Array<Museum>>(AppConst.API_ENDPOINT+"/museum/get-all");
  }

  public getMuseumWithVirtualTour(museumId:number){
    return this.http.get<MuseumWithVirtualTours>(AppConst.API_ENDPOINT+"/museum?museumId="+museumId+"&token=asd");
  }
}
