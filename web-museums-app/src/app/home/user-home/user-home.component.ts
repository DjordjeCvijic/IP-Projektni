import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
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
  public form:FormGroup=new FormGroup({});
  
  constructor(private museumService:MuseumService,
    private formBuilder:FormBuilder) { }

  ngOnInit(): void {
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

  public filter(){
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

}
