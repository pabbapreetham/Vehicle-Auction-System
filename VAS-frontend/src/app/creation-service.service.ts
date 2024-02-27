import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { sellerCompanyDTO } from './sellerCompanyDTO';
import { subTeamDTO } from './subTeamDTO';
import { SellerDTO } from './SellerDTO';
import { User } from './User';
import { vehicleDTO } from './vehicleDTO';

@Injectable({
  providedIn: 'root'
})
export class CreationServiceService {

  companyApiUrl = 'http://localhost:8081/sellercompany';
  subTeamApiUrl = 'http://localhost:8081/subteam';
  sellerApiUrl = 'http://localhost:8081/seller';
  userApiUrl = 'http://localhost:8081/user';
  vehicleApiUrl = 'http://localhost:8081/vehicle';

  constructor(private httpClient: HttpClient) { }

  getAllCompanies(): Observable<any> {

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.get(this.companyApiUrl + '/all');
  }

  getAllCompanyDTOs(): Observable<any> {

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.get(this.companyApiUrl + '/alldto');
  }

  addSellerCompany(body: sellerCompanyDTO): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.companyApiUrl + '/create', body, httpOptions);
  }

  getSubTeamsForcompanyId(companyId: number): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.get(this.subTeamApiUrl + '/all/'+ companyId, httpOptions);
  }

  addSubTeam(body: subTeamDTO): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.subTeamApiUrl + '/create', body, httpOptions);
  }

  getSellersForNoUsers(): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.get(this.sellerApiUrl + '/allnonusers', httpOptions);
  }

  getSellers(): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.get(this.sellerApiUrl + '/all', httpOptions);
  }

  addSeller(body: SellerDTO): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.sellerApiUrl + '/create', body, httpOptions);
  }

  updateSellerStatus(sellerId: number, status: number): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.put(this.sellerApiUrl + '/updatestatus/' + sellerId + '/' + status, httpOptions);
  }

  addUser(body: User): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.userApiUrl + '/create', body, httpOptions);
  }

  login(body: User): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.userApiUrl + '/login', body, httpOptions);
  }

  getVehiclesDataForUserId(userId: number): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.get(this.vehicleApiUrl + '/all/'+ userId, httpOptions);
  }

  addVehicle(vehicle: vehicleDTO): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.vehicleApiUrl + '/create', vehicle, httpOptions);
  }

}
