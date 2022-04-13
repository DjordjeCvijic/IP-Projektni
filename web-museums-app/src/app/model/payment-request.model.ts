export class PaymentRequest{
    firstName:String;
    lastName:String;
    cardNumber:String;
    cardTypeId:number;
    expirationDate:String;
    pin:number;
    virtualTourId:number;
    userId:number;
    amount:number;


    constructor(firstName:String,
        lastName:String,
        cardNumber:String,
        cardTypeId:number,
        expirationDate:String,
        pin:number,
        virtualTourId:number,
        userId:number,
        amount:number){
            this.amount=amount;
            this.cardNumber=cardNumber;
            this.cardTypeId=cardTypeId;
            this.expirationDate=expirationDate;
            this.firstName=firstName;
            this.lastName=lastName;
            this.pin=pin;
            this.virtualTourId=virtualTourId;
            this.userId=userId;

    }
}