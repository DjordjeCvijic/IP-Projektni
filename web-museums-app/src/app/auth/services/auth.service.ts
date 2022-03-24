import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) { }


  public login(username:String,password:String){
    console.log(username)
  }
  

 public singUp(firstName:string,lastName:string,username:string,email:string,password:string){
    const body = { 
      firstName: firstName,
      lastName:lastName,
      email:email,
      username:username,
      password:password
    };
    
   return this.http.post<any>('http://localhost:1123/auth/registration',body);
    // .subscribe({
    //   next: data => {

    //     console.log("radi");
    //     console.log(data.toString());
    //     console.log(data.status);
    //     console.log(data.opis);
    //   },
    //   error: error => {
    //     console.log("greska se desila");
    //     console.log(error.message.toString());
        
    //   }
    // })

  }

}