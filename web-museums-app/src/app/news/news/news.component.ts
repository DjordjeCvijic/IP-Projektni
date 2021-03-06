import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AppConst } from 'src/app/app_const';
import { AuthService } from 'src/app/auth/services/auth.service';
import { NewsService } from '../news.service';
import * as xml2js from "xml2js";
import {Parser} from 'xml2js';
import { News } from 'src/app/model/news.model';
import { LocalStorageService } from 'src/app/global-services/local-storage.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  public isAdmin:boolean=false;
  public loggedInUser:string="";
  public newsData:Array<News>=new Array();
  constructor(
    private  authService:AuthService,
    private localStorageService:LocalStorageService,
    private snackBar:MatSnackBar,
    private newsService:NewsService) { }

 

  ngOnInit(): void {
    this.getDataFromRSS();
      this.isAdmin=this.localStorageService.getUserIsAdminFromToken();
      this.loggedInUser=this.localStorageService.getUsernameFromToken();
  }

  public logout(){
    this.authService.logOut();
    this.snackBar.open("You are logged out",undefined,{duration:1000});
  }
  public openAdminApp(){
    window.open(AppConst.ADMIN_APP_URL+"?token="+this.localStorageService.getUserTokenFromLocalStorage(), "_blank");
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
              this.newsData.push(new News(
                result.rss.channel[0].item[i].title[0].trim(),
                result.rss.channel[0].item[i].link[0],
                result.rss.channel[0].item[i].description[0].trim(),
                result.rss.channel[0].item[i].enclosure[0].$.url,
                result.rss.channel[0].item[i].pubDate[0]
              ));
            }
            

          });
      }
    })
  }

}
