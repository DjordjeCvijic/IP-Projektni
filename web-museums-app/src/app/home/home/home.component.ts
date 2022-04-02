import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { AppConst } from 'src/app/app_const';
import { AuthService } from 'src/app/auth/services/auth.service';
import { Museum } from 'src/app/model/museum.model';
import { MuseumService } from '../services/museum.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

 
 

  constructor(private  authService:AuthService,
    private snackBar:MatSnackBar
    
   ) { }

  ngOnInit(): void {
    
  }

  public logout(){
    this.authService.logOut();
    this.snackBar.open("izlogovani ste",undefined,{duration:2000})
  }
  public openAdminApp(){
    window.open(AppConst.ADMIN_APP_URL+"?token="+this.authService.getUserTokenFromLocalStorage(), "_blank");
  }

}
