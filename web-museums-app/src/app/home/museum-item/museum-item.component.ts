import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Museum } from 'src/app/model/museum.model';

@Component({
  selector: 'app-museum-item',
  templateUrl: './museum-item.component.html',
  styleUrls: ['./museum-item.component.css']
})
export class MuseumItemComponent implements OnInit {

  @Input("museum") public museum!:Museum;
  
  constructor(private router:Router) { }

  ngOnInit(): void {
  
  }

   public openMuseumPage(){
      this.router.navigate(["home/museum"],{queryParams:{museumId:this.museum?.museumId}});
  }

}
