import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeModule } from './home/home.module';

const routes: Routes = [
  {
    path:"",
    loadChildren:()=> import("./welcome/welcome.module").then(mod=>mod.WelcomeModule)
  },
  {
    path:"auth",
    loadChildren:()=> import("./auth/auth.module").then(mod=>mod.AuthModule)
  },
  {
    path:"home",
    loadChildren:()=>import("./home/home.module").then(mod=>HomeModule)
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
