import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MuseumWithVirtualTours } from 'src/app/model/museum-with-virtual-tours.mode';
import { MuseumService } from '../services/museum.service';

@Component({
  selector: 'app-museum',
  templateUrl: './museum.component.html',
  styleUrls: ['./museum.component.css']
})
export class MuseumComponent implements OnInit {

  
  public museum: MuseumWithVirtualTours=new MuseumWithVirtualTours();
  public museumId:number=0;
  constructor(private activeRoute:ActivatedRoute,private museumService:MuseumService) { }

  ngOnInit(): void {
    this.activeRoute.queryParams.subscribe(params => {
      
      this.museumId=params["museumId"];
    });
    this.museumService.getMuseumWithVirtualTour(this.museumId).subscribe({
      next:data=>{
        this.museum=data;
        
      }
    });
    
  }

}
