import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { configs } from '../config';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
    url = configs.BACKEND_BASE_URL + "/api/producto"
    constructor( private httpClient:HttpClient ){}

    list() {
        return this.httpClient.get<Array<Product>>(this.url)
    }

    getOne(id: Number) {
        return this.httpClient.get(this.url + "/" + id)
    }

    insert(product: any) {
        return this.httpClient.post(this.url, product)
    }

    update(product: any) {
        return this.httpClient.put(this.url, product)
    }

    delete(id: Number) {
        return this.httpClient.delete(this.url + "/" + id)
    }
}