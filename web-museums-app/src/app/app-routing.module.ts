import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuardService } from './auth/services/guard.service';
import { HomeModule } from './home/home.module';
import { NewsModule } from './news/news.module';
import { NewsComponent } from './news/news/news.component';

const routes: Routes = [
  {
    path:"",
    loadChildren:()=> import("./welcome/welcome.module").then(mod=>mod.WelcomeModule),
    
  },
  {
    path:"auth",
    loadChildren:()=> import("./auth/auth.module").then(mod=>mod.AuthModule)
  },
  {
    path:"home",
    loadChildren:()=>import("./home/home.module").then(mod=>HomeModule),
    canActivate:[GuardService]
  },
  {
    path:"news",
    loadChildren:()=>import("./news/news.module").then(mod=>NewsModule),
    canActivate:[GuardService]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
