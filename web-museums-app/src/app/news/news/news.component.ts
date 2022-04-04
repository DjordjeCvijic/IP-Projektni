import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AppConst } from 'src/app/app_const';
import { AuthService } from 'src/app/auth/services/auth.service';
import { NewsService } from '../news.service';
import * as xml2js from "xml2js";
import {Parser} from 'xml2js';
import { News } from 'src/app/model/news.model';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  constructor(private  authService:AuthService,
    private snackBar:MatSnackBar,private newsService:NewsService) { }

  private newsData:Array<News>=new Array();

  ngOnInit(): void {
    this.getDataFromRSS();
      this.newsService.getNewsData();
  }

  public logout(){
    this.authService.logOut();
    this.snackBar.open("izlogovani ste",undefined,{duration:2000})
  }
  public openAdminApp(){
    window.open(AppConst.ADMIN_APP_URL+"?token="+this.authService.getUserTokenFromLocalStorage(), "_blank");
  }
  private getDataFromRSS(){
    const p: Parser = new xml2js.Parser();
    this.newsService.getNewsData().subscribe({
      next:data=>{
        p.parseString(data, (err: any, result: any) => {
              if (err) {
                  throw err;
              }
            for(let i=0;i<result.rss.channel[0].item.length;i++){
              // console.log(result.rss.channel[0].item[i].title[0].trim());//naslov
              this.newsData.push(new News(
                result.rss.channel[0].item[i].title[0].trim(),
                result.rss.channel[0].item[i].link[0],
                result.rss.channel[0].item[i].description[0].trim(),
                result.rss.channel[0].item[i].enclosure[0].$.url,
                result.rss.channel[0].item[0].pubDate[0]
              ));
            }
           
            // console.log(result.rss.channel[0].item[0].title[0].trim());//naslov
            // console.log(result.rss.channel[0].item[0].link[0]);//link za cijelu pricu
            // console.log(result.rss.channel[0].item[0].description[0].trim());//podnaslov
            // console.log(result.rss.channel[0].item[0].enclosure[0].$.url);//slika
            // console.log(result.rss.channel[0].item[0].pubDate[0]);//datum objavljivanja

          });
      }
    })
  }

}
