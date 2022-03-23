import { formatNumber } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {


  public form:FormGroup=new FormGroup({});
  constructor(private formBuilder:FormBuilder,
    private router:Router,
    private snackBar:MatSnackBar) { }

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
      this.snackBar.open("registrovani ste",undefined,{duration :2000});
      this.router.navigate(["auth/login"]);
  }

}
