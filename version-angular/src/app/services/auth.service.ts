import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url="https://fake-login-api-production.up.railway.app/api/auth/login";

  constructor( private httpClient:HttpClient ){}

  login(data:any){
    return this.httpClient.post(this.url, data)
  }

}
