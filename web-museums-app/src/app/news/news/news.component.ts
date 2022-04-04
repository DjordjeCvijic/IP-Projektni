import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AppConst } from 'src/app/app_const';
import { AuthService } from 'src/app/auth/services/auth.service';
import { NewsService } from '../news.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  constructor(private  authService:AuthService,
    private snackBar:MatSnackBar,private newsService:NewsService) { }

  ngOnInit(): void {
      this.newsService.getData();
  }

  public logout(){
    this.authService.logOut();
    this.snackBar.open("izlogovani ste",undefined,{duration:2000})
  }
  public openAdminApp(){
    window.open(AppConst.ADMIN_APP_URL+"?token="+this.authService.getUserTokenFromLocalStorage(), "_blank");
  }


}
