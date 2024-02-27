export class SellerDTO{
    sellerId: number = 0;
    sellerName: string = "";
    email: string = "";
    phone: number = 0;
    ext: number = 0;
    isSellerActive: boolean =true;
    subTeamIds: number[] = [];

    constructor(){
        
    }
}