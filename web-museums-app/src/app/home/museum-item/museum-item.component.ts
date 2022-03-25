import { Component, Input, OnInit } from '@angular/core';
import { Museum } from 'src/app/model/museum.model';

@Component({
  selector: 'app-museum-item',
  templateUrl: './museum-item.component.html',
  styleUrls: ['./museum-item.component.css']
})
export class MuseumItemComponent implements OnInit {

  @Input("museum") public museum:Museum|null=null;
  
  constructor() { }

  ngOnInit(): void {
    // console.log(this.museum);
  }

}
