import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { AppConst } from 'src/app/app_const';
import { AuthService } from 'src/app/auth/services/auth.service';
import { LocalStorageService } from 'src/app/global-services/local-storage.service';
import { Museum } from 'src/app/model/museum.model';
import { MuseumService } from '../services/museum.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public isAdmin:boolean=false;
  public loggedInUser:string=""; 
  constructor(private  authService:AuthService,private  localStorageService:LocalStorageService,
    private snackBar:MatSnackBar
   ) { }

  ngOnInit(): void {
    this.isAdmin=this.localStorageService.getUserIsAdminFromToken();
    this.loggedInUser=this.localStorageService.getUsernameFromToken();
  }

  public logout(){
    this.authService.logOut();
    this.snackBar.open("izlogovani ste",undefined,{duration:2000});
  }
  public openAdminApp(){
    window.open(AppConst.ADMIN_APP_URL+"?token="+this.localStorageService.getUserTokenFromLocalStorage(), "_blank");
  }



}
