export class PaymentResponse{
    status:number;
    description:String;

    constructor(status:number,
        description:String){
            this.description=description;
            this.status=status;
        }
}