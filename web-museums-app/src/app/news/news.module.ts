import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewsComponent } from './news/news.component';
import { NewsRoutingModule } from './news-routing.module';
import { AppMaterialModule } from '../app-material/app-material.module';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    NewsComponent
  ],
  imports: [HttpClientModule,
    NewsRoutingModule,
    CommonModule,
    AppMaterialModule
  ]
})
export class NewsModule { }
