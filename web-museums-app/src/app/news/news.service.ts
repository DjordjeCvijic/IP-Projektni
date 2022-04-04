import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NewsRss } from '../model/news-rss.model';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  private path: string = 'https://www.huffpost.com/section/arts/feed';
  constructor( private http: HttpClient) { }


  
  public getData(){
    return this.http.get(this.path,{responseType:"text"}).subscribe({
      next:data=>{
        console.log("dosao do tuuu", JSON.parse(data.toString()));

      }
    })
  }
  // getFeedContent(url: string): Observable<NewsRss> {
  //   return this.http.get(this.path)
  //           .map(this.extractFeeds)
  //           .catch(this.handleError);
  // }

  // private extractFeeds(res: Response): NewsRss {
  //   let feed = res.json();
  //   return feed || { };
  // }

  // private handleError (error: any) {
  //   // In a real world app, we might use a remote logging infrastructure
  //   // We'd also dig deeper into the error to get a better message
  //   let errMsg = (error.message) ? error.message :
  //     error.status ? `${error.status} - ${error.statusText}` : 'Server error';
  //   console.error(errMsg); // log to console instead
  //   return Observable.throw(errMsg);
  // }
}
