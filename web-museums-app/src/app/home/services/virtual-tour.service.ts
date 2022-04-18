import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConst } from 'src/app/app_const';
import { LocalStorageService } from 'src/app/global-services/local-storage.service';
import { VirtualTour } from 'src/app/model/virtual-tour.model';

@Injectable({
  providedIn: 'root'
})
export class VirtualTourService {

  constructor(private http:HttpClient,
    private localStorageService:LocalStorageService
    ) { }


  getVirtualTourListForUser(userId:number){
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer '+this.localStorageService.getUserTokenFromLocalStorage(),
    }
    );
    return this.http.get<Array<VirtualTour>>(AppConst.API_ENDPOINT+"/virtual-tour/get-by-user?userId="+userId,{ headers: headers });
  }
}
