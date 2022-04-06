import { Weather } from "./weather.model";

export class Museum{
    museumId:String;
    name:String;
    address:String;
    phoneNumber:number;
    countryName:String;
    cityName:String;
    latitude:String;
    longitude:String;
    museumType:String;

    constructor(
        museumId:String,
        name:String,
        address:String,
        phoneNumber:number,
        countryName:String,
        cityName:String,
        latitude:String,
        longitude:String,
        museumType:String,
        ){

        this.museumId=museumId;
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.countryName=countryName;
        this.cityName=cityName;
        this.latitude=latitude;
        this.longitude=longitude;
        this.museumType=museumType;
        

    }

       
}