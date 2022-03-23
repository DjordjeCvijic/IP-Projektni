import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public form:FormGroup=new FormGroup({});

  constructor(private formBuilder:FormBuilder,
    private snackBar:MatSnackBar,
    ) { }

  ngOnInit(): void {
    this.form=this.formBuilder.group({
      username:[null,Validators.required],
      password:[null,Validators.required],
    });
  }


  public login(form:any){
    if(form.value.username=="test" && form.value.password=="test"){
      this.snackBar.open("uspijesno",undefined, {
        duration: 2000
      });
    }else{
      this.snackBar.open("neuspijesno",undefined, {
        duration: 2000
      });
    }
  


  }

}
 