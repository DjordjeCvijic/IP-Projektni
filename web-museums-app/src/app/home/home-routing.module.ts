import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MuseumComponent } from './museum/museum.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { VirtualToursComponent } from './virtual-tours/virtual-tours.component';


const routes: Routes = [
    {
        path:"",
        component:HomeComponent,
        children:[
          {
            path:"",
            component:UserHomeComponent
          },
          {
            path:"museum",
            component:MuseumComponent
          },
          {
            path:"virtual-tours",
            component:VirtualToursComponent
          }
        ]
        
    }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
