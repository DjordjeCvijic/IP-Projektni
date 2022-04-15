import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConst } from 'src/app/app_const';
import { VirtualTour } from 'src/app/model/virtual-tour.model';

@Injectable({
  providedIn: 'root'
})
export class VirtualTourService {

  constructor(private http:HttpClient) { }


  getVirtualTourListForUser(userId:number){
    return this.http.get<Array<VirtualTour>>(AppConst.API_ENDPOINT+"/virtual-tour/get-by-user?userId="+userId);
  }
}
