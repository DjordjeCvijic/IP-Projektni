import { Component, Input, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataset, Chart, ChartData } from 'chart.js';
import {  } from 'ng2-charts';
import { LoginCount } from 'src/app/model/login-count.model';
import { LoginHistoryService } from '../services/login-history.service';

@Component({
  selector: 'app-bar-chart',
  templateUrl: './bar-chart.component.html',
  styleUrls: ['./bar-chart.component.css']
})
export class BarChartComponent implements OnInit {

 
  public barChartData: ChartData<'bar'> = {
    labels: [],
    datasets: [
      {
        data: [],
      }
    ]
  };
  public barChartOptions: ChartOptions = {
    responsive: true,
    plugins: {
      title: {
        fullSize:true,
        display: true,
        text: '',
      },
      legend: {
        display: false
      },
    },
  };
  public barChartType: ChartType = 'bar';
  private barChartLabels:number[] =[];
  private chartData:number[] =[];
  constructor(private loginHistoryService:LoginHistoryService){
  }
  
  ngOnInit(): void { 
       this.getLoginCount();   
    
  }
  
    getLoginCount(){
     this.loginHistoryService.getLoginCount().subscribe({
      next: data => {
        data.forEach(element => {
           this.barChartLabels.push(element.hour);
          this.chartData.push(element.count);
        }); 
       
        this.barChartData = {
          labels: this.barChartLabels,
          datasets: [
            {
              data: this.chartData,
              backgroundColor: ["#7DB7F0"],
              hoverBackgroundColor: ["#1e90ff"]

            }
          ]
        };

      }
    })

  }
}


