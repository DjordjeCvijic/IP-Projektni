export class Weather{
    description:string;
    temperature:string;
    pressure:string;
    humidity:string;
    visibility:string;
    windSpeed:string;
    name:string;

    constructor(
        description:string,
    temperature:string,
    pressure:string,
    humidity:string,
    visibility:string,
    windSpeed:string,
    name:string
    ){
        this.description=description;
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        this.visibility=visibility;
        this.windSpeed=windSpeed;
        this.name=name;
    }
}