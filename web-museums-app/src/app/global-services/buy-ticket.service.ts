import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConst } from '../app_const';
import { PaymentRequest } from '../model/payment-request.model';
import {PaymentResponse} from '../model/payment-response.model';

@Injectable({
  providedIn: 'root'
})
export class BuyTicketService {

  constructor(private http:HttpClient) { }

  buyTicket(request:PaymentRequest ){
    return this.http.post<PaymentResponse>(AppConst.VIRTUAL_BANK_SERVICE_API+"/payment",request);
  }

}
