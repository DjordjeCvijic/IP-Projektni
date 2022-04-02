import { Component, OnInit } from '@angular/core';
import { Museum } from 'src/app/model/museum.model';
import { MuseumService } from '../services/museum.service';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {


  public museums=new Array<Museum>();
  
  constructor(private museumService:MuseumService) { }

  ngOnInit(): void {
    this.museumService.getAllMuseums().subscribe({
      next:data=>{
        data.forEach(element=>this.museums.push(element));
      }
     })
 
  }

}
