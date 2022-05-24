import { formatNumber } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
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
      username:["",Validators.compose([Validators.required,Validators.minLength(12),this.customValidatorForUsername])],
      email:[null,Validators.required],
      firstPassword:[null,Validators.compose([Validators.required,Validators.pattern('^(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=\\D*\\d)[A-Za-z\\d!$%@#£€*?&]{15,}$')])],
      secondPassword:[null,Validators.required]
    });
  }

  public singUp(form:any){
    if(form.value.firstPassword!=form.value.secondPassword){
      this.snackBar.open("Please enter identical passwords",undefined,{duration:2000})
    }else{
      console.log("proslo");
      this.authService.singUp(form.value.firstName,form.value.lastName,form.value.username,form.value.email,form.value.firstPassword).subscribe({
      next:data=>{
        if(data.status=="2"){
          this.snackBar.open("Username already taken",undefined,{duration:2000})
        }else if(data.status=="3"){
          this.snackBar.open("Email already taken",undefined,{duration:2000})
        }else if(data.status=="1"){
          this.snackBar.open("You have successfully signed up",undefined,{duration:2000});
          this.router.navigate(["auth/login"]);
        }
      }
    }
    )
  }
 
  }
  customValidatorForUsername(control: AbstractControl){
    if(control.value.includes("@") || control.value.includes("#") ||control.value.includes("/")){
      return {errorCpf: true}
    }
    return null;
  }
  customValidatorForPassword(control: AbstractControl){
    if(control.value.includes("@") || control.value.includes("#") ||control.value.includes("/")){
      return {errorCpf: true}
    }
    return null;
}

}
