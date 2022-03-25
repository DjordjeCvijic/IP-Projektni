import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class GuardService implements CanActivate{

  constructor(private auth:AuthService,
    private router:Router) { }

  canActivate(): boolean{
    if(this.auth.getUserTokenFromLocalStorage()!=null){
      return true;
    }else{
      this.router.navigate([""]);
      return false;
    }
  }


}
