import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthService } from 'src/app/auth/services/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private  authService:AuthService,
    private snackBar:MatSnackBar) { }

  ngOnInit(): void {
  }


  public logout(){
    this.authService.logOut();
    this.snackBar.open("izlogovani ste",undefined,{duration:2000})
  }

}
