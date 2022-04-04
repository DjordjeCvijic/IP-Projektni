import { Component, Input, OnInit } from '@angular/core';
import { News } from 'src/app/model/news.model';

@Component({
  selector: 'app-news-item',
  templateUrl: './news-item.component.html',
  styleUrls: ['./news-item.component.css']
})
export class NewsItemComponent implements OnInit {

  @Input("news") news?:News;
  // public news:News=new News("naslov","","podnaslov","","datum pobave")
  constructor() { }

  ngOnInit(): void {
  }

}
