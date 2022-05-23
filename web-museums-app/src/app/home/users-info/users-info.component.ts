import { Component, OnInit } from '@angular/core';
import { ChartData, ChartOptions,ChartType } from 'chart.js';
import { UsersInfoService } from '../services/users-Info.service';

@Component({
  selector: 'app-users-info',
  templateUrl: './users-info.component.html',
  styleUrls: ['./users-info.component.css']
})
export class UsersInfoComponent implements OnInit {

  public barChartData: ChartData<'bar'> = {
    labels: [],
    datasets: [
      {
        data: [],
      }
    ]
  };
  public barChartOptions: ChartOptions = {
    responsive: false,
    plugins: {
      title: {
        fullSize:true,
        display: true,
        text: "Number of users in the last 24 hour",
      },
      legend: {
        display: false
      },
    },
  };
  public barChartType: ChartType = 'bar';
  public registeredUsersNumber?:number;
  public activeUsersNumber?:number;
  private barChartLabels:number[] =[];
  private chartData:number[] =[];
  constructor(private usersInfoService:UsersInfoService) { }

  ngOnInit(): void {
    this.getLoginCount(); 
  }


  getLoginCount(){
    this.usersInfoService.getLoginCount().subscribe({
     next: data => {
       data.loginCountList.forEach(element => {
          this.barChartLabels.push(element.hour);
         this.chartData.push(element.count);
       }); 
      
       this.barChartData = {
         labels: this.barChartLabels,
         datasets: [
           {
             data: this.chartData,
             backgroundColor: ["#7DB7F0"],
             //hoverBackgroundColor: ["#1e90ff"]

           }
         ]
       };

       this.registeredUsersNumber=data.registeredUsersCount;
      this.activeUsersNumber=data.activeUsersCount;
     }
   })

 }
}
