import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { News } from '../model/news.model';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  private rssPath: string = 'https://www.huffpost.com/section/arts/feed';

  constructor( private http: HttpClient) { }
 

  
  public getNewsData(){
   
    return this.http.get(this.rssPath,{responseType:"text"});
  }
  
}
