import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { configs } from '../config';
import { LoginResponse } from '../models/login-response';
import { BehaviorSubject, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loggedUser = new BehaviorSubject<LoginResponse|null>(null);


  constructor( private httpClient:HttpClient ){}

  login(data:any){
    const url = configs.BACKEND_BASE_URL + "/api/usuario/login"
    return this.httpClient.post<LoginResponse>(url, data).pipe(
      tap((user) => this.loggedUser.next(user))
    )
  }

  signup(data: any) {
    const url = configs.BACKEND_BASE_URL + "/api/usuario-cliente"
    return this.httpClient.post(url, data)
  }

  signout() {
    this.loggedUser.next(null);
  }

}
