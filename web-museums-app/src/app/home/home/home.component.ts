import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/auth/services/auth.service';
import { Museum } from 'src/app/model/museum.model';
import { MuseumService } from '../services/museum.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

 public museums=new Array<Museum>();
 

  constructor(private  authService:AuthService,
    private snackBar:MatSnackBar,
    private museumService:MuseumService
   ) { }

  ngOnInit(): void {
    this.museumService.getAllMuseums().subscribe({
     next:data=>{
       data.forEach(element=>this.museums.push(element));
     }
    })

    
  }


  public logout(){
   
    this.authService.logOut();
    this.snackBar.open("izlogovani ste",undefined,{duration:2000})
  }
  public openAdminApp(){
    window.open("http://localhost:8080/WebMuseumsAdmin", "_blank");
  }

}
