
export class VirtualTour{
    virtualTourId:number;
    name:String;
    startDateTime:String;
    duration:number;
    youtubeUrl:String;
    purchasedByUser:boolean;

    constructor(
        virtualTourId?:number,
        name?:String,
        startDateTime?:String,
        duration?:number,
        youtubeUrl?:String,
        purchasedByUser?:boolean
    ){
        this.duration=duration||0;
        this.name=name||"";
        this.purchasedByUser=purchasedByUser||false;
        this.startDateTime=startDateTime||"";
        this.virtualTourId=virtualTourId||0;
        this.youtubeUrl=youtubeUrl||"";
    }

}