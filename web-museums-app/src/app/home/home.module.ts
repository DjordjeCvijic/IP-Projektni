import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { HomeRoutingModule } from './home-routing.module';
import { AppMaterialModule } from '../app-material/app-material.module';
import { HttpClientModule } from '@angular/common/http';
import { MuseumItemComponent } from './museum-item/museum-item.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { MuseumComponent } from './museum/museum.component';
import { VirtualTourCardComponent } from './virtual-tour-card/virtual-tour-card.component';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    HomeComponent,
    MuseumItemComponent,
    UserHomeComponent,
    MuseumComponent,
    VirtualTourCardComponent,
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    AppMaterialModule,
    HttpClientModule,
    ReactiveFormsModule
  ]
})
export class HomeModule { }
