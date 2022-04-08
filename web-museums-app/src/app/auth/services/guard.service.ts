import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LocalStorageService } from 'src/app/global-services/local-storage.service';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class GuardService implements CanActivate{

  constructor(private localStorageService:LocalStorageService,
    private router:Router) { }

  canActivate(): boolean{
    if(this.localStorageService.getUserTokenFromLocalStorage()!=null){
      return true;
    }else{
      this.router.navigate([""]);
      return false;
    }
  }


}
