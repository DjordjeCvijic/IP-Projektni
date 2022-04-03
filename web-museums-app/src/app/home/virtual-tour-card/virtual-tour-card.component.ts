import { Component, Input, OnInit } from '@angular/core';
import { VirtualTour } from 'src/app/model/virtual-tour.model';

@Component({
  selector: 'app-virtual-tour-card',
  templateUrl: './virtual-tour-card.component.html',
  styleUrls: ['./virtual-tour-card.component.css']
})
export class VirtualTourCardComponent implements OnInit {

  @Input("virtualTour") public virtualTour!:VirtualTour
  constructor() { }

  ngOnInit(): void {
  }

  public buyTicket(virtualTourId:number){
    console.log("pritisnuo kupi kartu",virtualTourId);
  }

}