import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { HomeRoutingModule } from './home-routing.module';
import { AppMaterialModule } from '../app-material/app-material.module';
import { HttpClientModule } from '@angular/common/http';
import { MuseumItemComponent } from './museum-item/museum-item.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { MuseumComponent } from './museum/museum.component';



@NgModule({
  declarations: [
    HomeComponent,
    MuseumItemComponent,
    UserHomeComponent,
    MuseumComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    AppMaterialModule,
    HttpClientModule
  ]
})
export class HomeModule { }
