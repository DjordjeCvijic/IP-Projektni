import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LocalStorageService } from '../global-services/local-storage.service';
import { VirtualBankService } from '../global-services/virtual-bank.service';
import { CardType } from '../model/card-type.model';
import { PaymentRequest } from '../model/payment-request.model';


@Component({
  selector: 'app-buy-ticket-modal',
  templateUrl: './buy-ticket-modal.component.html',
  styleUrls: ['./buy-ticket-modal.component.css']
})
export class BuyTicketModalComponent implements OnInit {

  public form:FormGroup=new FormGroup({});
  public selectedCardType:number = 0;
  public cardTypeList:Array<CardType>=[];
  private virtualTourId=0;
  constructor(private dialogRef:MatDialogRef<BuyTicketModalComponent>,
    private formGroupBuilder:FormBuilder,
    private virtualBankService:VirtualBankService ,
    private snackBar:MatSnackBar,
    private localStorageService:LocalStorageService,
    @Inject(MAT_DIALOG_DATA) data: any) { 
      this.virtualTourId=data.virtualTourId;
    }

  ngOnInit(): void {

    
    this.form=this.formGroupBuilder.group({
      firstName:[null,Validators.required],
      lastName:[null,Validators.required],
      cardNumber:[null,Validators.required],
      cardType:[null,Validators.required],
      pin:[null,Validators.required],
      expirationDate:[null,Validators.required]
    })
    this.getCardTypeList();

  }

  close(){
    this.dialogRef.close();
  }

  confirm(form:any){
    this.snackBar.open("Data processing in progress",undefined,{duration:2000})
    var requestBody:PaymentRequest=new PaymentRequest(form.value.firstName,form.value.lastName,form.value.cardNumber,
      form.value.cardType,form.value.expirationDate,form.value.pin,this.virtualTourId,this.localStorageService.getUserIdFromToken(),100.00)
    this.virtualBankService.buyTicket(requestBody).subscribe({
        next:data=>{
          this.snackBar.open(data.description.toString(),undefined,{duration:2000});
            if(data.status==1){
              this.dialogRef.close(true);
            }
        }
    })

    
  }
  private getCardTypeList(){
    this.virtualBankService.getAllCardType().subscribe({
      next:data=>{
        data.forEach(element => {
          this.cardTypeList.push(element);
        });
      }
    })
  }

}
