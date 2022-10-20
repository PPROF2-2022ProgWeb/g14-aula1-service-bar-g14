import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Products } from '../interface/products';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  URL = "https://run.mocky.io/v3/78addcf6-2b58-41c1-9d63-c288a79b6b7a"

  constructor(
    private httpClient:HttpClient
  ){}

  getProducts(){
    return this.httpClient.get<Products>(this.URL);
  }


}
