import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DateAdapter } from '@angular/material/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { access } from 'fs';
import { AppConst } from 'src/app/app_const';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public form:FormGroup=new FormGroup({});

  constructor(private formBuilder:FormBuilder,
    private snackBar:MatSnackBar,
    private authService:AuthService,
    private router:Router
    ) { }

  ngOnInit(): void {
    this.form=this.formBuilder.group({
      username:[null,Validators.required],
      password:[null,Validators.required],
    });
  }


  public login(form:any){
    this.authService.login(form.value.username,form.value.password).subscribe({
      next:result=>{
        if(result.status==2){
          this.snackBar.open("kredincijalni nisu validni",undefined,{duration:2000})
        }else if(result.status==3){
          this.snackBar.open("ACCOUNT STATUS: "+result.jwt,undefined,{duration:2000})
        }
        else if(result.status==1){
          this.authService.saveUserTokenToLocalStorage(result.data);
          this.snackBar.open("uspijesno ste se ulogovali",undefined, {
            duration: 2000
          });
          this.router.navigate(["/home"]);
        }
      }
    })


  }

}
 