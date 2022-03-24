import { formatNumber } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {


  public form:FormGroup=new FormGroup({});
  constructor(private formBuilder:FormBuilder,
    private router:Router,
    private snackBar:MatSnackBar,
    private authService:AuthService) { }

  ngOnInit(): void {
    this.form=this.formBuilder.group({
      firstName:[null,Validators.required],
       lastName:[null,Validators.required],
      username:[null,Validators.required],
      email:[null,Validators.required],
      firstPassword:[null,Validators.required],
      secondPassword:[null,Validators.required]
    });
  }

  public singUp(form:any){
    if(form.value.firstPassword!=form.value.secondPassword){
      this.snackBar.open("Lozinke nisu iste",undefined,{duration:2000})
    }
    this.authService.singUp(form.value.firstName,form.value.lastName,form.value.username,form.value.email,form.value.firstPassword).subscribe({
      next:data=>{
        if(data.status=="2"){
          this.snackBar.open("korisnicko ime postoji",undefined,{duration:2000})
        }else if(data.status=="3"){
          this.snackBar.open("email ime postoji",undefined,{duration:2000})
        }else if(data.status=="1"){
          this.snackBar.open("uspijesno ste se registrovali",undefined,{duration:2000});
          this.router.navigate(["auth/login"]);
        }
      }
    })

  
  }

}
