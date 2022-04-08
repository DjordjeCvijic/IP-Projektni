import { newArray } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { LocalStorageService } from 'src/app/global-services/local-storage.service';
import { LoginCount } from 'src/app/model/login-count.model';
import { Museum } from 'src/app/model/museum.model';
import { MuseumService } from '../services/museum.service';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {


  private museums=new Array<Museum>();
  public museumsToShow=new Array<Museum>();
  public loginCount=new Array<LoginCount>();
  public form:FormGroup=new FormGroup({});
  public isAdmin:boolean=false;
  
  constructor(private museumService:MuseumService,
    private formBuilder:FormBuilder,private localStorageService:LocalStorageService) { }

  ngOnInit(): void {
    this.isAdmin=this.localStorageService.getUserRoleFromLocalStorage();
    this.getMuseums();
  
  }

  public filter(){
    console.log("broj podataka ",this.loginCount.length);
    if(this.form.value.museumNameField != null){
      console.log("postoji naziv muzeja");
      this.museumsToShow=this.museums.filter((element, index, array)=>{
        return element.name.toLowerCase().includes(this.form.value.museumNameField);
      });
    }
    if(this.form.value.locationField != null){
      console.log("postoji lokaicja muzeja");
      this.museumsToShow=this.museumsToShow.filter((element, index, array)=>{
        return element.cityName.toLowerCase().includes(this.form.value.locationField);
      });
    }

  }
  public showAll(){
    this.museumsToShow=this.museums;
    this.form.reset();
  }

  getMuseums(){
    this.museumService.getAllMuseums().subscribe({
      next:data=>{
        data.forEach(element=>{
          this.museums.push(element);
          this.museumsToShow.push(element);
        });
        
      }
     });
     this.form=this.formBuilder.group({museumNameField:[null],locationField:[null]})
  }
  

}
