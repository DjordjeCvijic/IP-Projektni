import { VirtualTour } from "./virtual-tour.model";

export class MuseumWithVirtualTours{
    name:String;
    museumId:number;
    address:String;
    phoneNumber:String;
    countryName:String;
    cityName:String;
    latitude:String;
    longitude:String;
    museumType:String;
    virtualTourList:Array<VirtualTour>;


    constructor(
        name?:String,
        museumId?:number,
        address?:String,
        phoneNumber?:String,
        countryName?:String,
        cityName?:String,
        latitude?:String,
        longitude?:String,
        museumType?:String,
        virtualTourList?:Array<VirtualTour>
    ){
        this.address=address||"";
        this.cityName=cityName||"";
        this.countryName=countryName||"";
        this.latitude=latitude||"";
        this.longitude=longitude||"";
        this.museumId=museumId||0;
        this.museumType=museumType||"";
        this.name=name||"";
        this.phoneNumber=phoneNumber||"";
        this.virtualTourList=virtualTourList||[];
    }
}


