import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { HomeRoutingModule } from './home-routing.module';
import { AppMaterialModule } from '../app-material/app-material.module';
import { HttpClientModule } from '@angular/common/http';
import { MuseumItemComponent } from './museum-item/museum-item.component';



@NgModule({
  declarations: [
    HomeComponent,
    MuseumItemComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    AppMaterialModule,
    HttpClientModule
  ]
})
export class HomeModule { }
