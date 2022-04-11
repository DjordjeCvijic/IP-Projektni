import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BuyTicketModalComponent } from 'src/app/buy-ticket-modal/buy-ticket-modal.component';
import { VirtualTour } from 'src/app/model/virtual-tour.model';

@Component({
  selector: 'app-virtual-tour-card',
  templateUrl: './virtual-tour-card.component.html',
  styleUrls: ['./virtual-tour-card.component.css']
})
export class VirtualTourCardComponent implements OnInit {

  @Input("virtualTour") public virtualTour!:VirtualTour
  constructor(private matDialog:MatDialog) { }

  ngOnInit(): void {
  }

  public buyTicket(virtualTourId:number){
    this.matDialog.open(BuyTicketModalComponent, {
      width: '600px'
    })
      .afterClosed()
      .subscribe(result => {
       console.log("resltat :",result)
      });
  }

}