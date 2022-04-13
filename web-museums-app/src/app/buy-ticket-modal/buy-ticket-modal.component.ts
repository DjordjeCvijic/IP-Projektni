import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { BuyTicketService } from '../global-services/buy-ticket.service';
import { LocalStorageService } from '../global-services/local-storage.service';
import { PaymentRequest } from '../model/payment-request.model';


@Component({
  selector: 'app-buy-ticket-modal',
  templateUrl: './buy-ticket-modal.component.html',
  styleUrls: ['./buy-ticket-modal.component.css']
})
export class BuyTicketModalComponent implements OnInit {

  public form:FormGroup=new FormGroup({});
  private virtualTourId=0;
  constructor(private dialogRef:MatDialogRef<BuyTicketModalComponent>,
    private formGroupBuilder:FormBuilder,private buyTicetService:BuyTicketService ,
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
  }

  close(){
    this.dialogRef.close();
  }

  confirm(form:any){
    console.log("proslijedjena vrijednosti ",this.virtualTourId)
    var requestBody:PaymentRequest=new PaymentRequest(form.value.firstName,form.value.lastName,form.value.cardNumber,
      form.value.cardType,form.value.expirationDate,form.value.pin,this.virtualTourId,this.localStorageService.getUserIdFromToken(),100.00)
    this.buyTicetService.buyTicket(requestBody).subscribe({
        next:data=>{
          this.snackBar.open(data.description.toString(),undefined,{duration:2000});
            if(data.status==1){
              this.dialogRef.close(true);
            }
        }
    })

    
  }

}
