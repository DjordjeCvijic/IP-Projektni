export class News{
    title:string;
    url:string;
    subtitle:string;
    imageUrl:string;
    pubDate:string;


    constructor(title:string,url:string,subtitle:string,imageUrl:string,pubDate:string){
        this.title=title;
        this.url=url;
        this.subtitle=subtitle;
        this.imageUrl=imageUrl;
        this.pubDate=pubDate;
    }
}