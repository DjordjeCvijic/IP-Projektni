import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from 'src/app/global-services/local-storage.service';
import { VirtualTour } from 'src/app/model/virtual-tour.model';
import { VirtualTourService } from '../services/virtual-tour.service';

@Component({
  selector: 'app-virtual-tours',
  templateUrl: './virtual-tours.component.html',
  styleUrls: ['./virtual-tours.component.css']
})
export class VirtualToursComponent implements OnInit {

  public virtualTourList:Array<VirtualTour>=[];
  public videoToShow:string="";
  public title:string="";
  constructor(private localStorageService:LocalStorageService,
    private virtualTourService:VirtualTourService
    ) { }

  ngOnInit(): void {

    this.getVirtualTourList();
  }
  getVirtualTourList() {
    let userId=this.localStorageService.getUserIdFromToken();
    this.virtualTourService.getVirtualTourListForUser(userId).subscribe({
      next:data=>{
        data.forEach(element => {
          this.virtualTourList.push(element);
        });
      }
    })
  }

  showVirtualTour(virtualTourId:number){
    var virtualTour:VirtualTour;
    this.virtualTourList.forEach(element=>{if(element.virtualTourId==virtualTourId)virtualTour=element;})
    const params = new URL(virtualTour!.youtubeUrl.toString()).searchParams;
    this.videoToShow = params.get('v')!;
    this.title=virtualTour!.name.toString();
  }

}
