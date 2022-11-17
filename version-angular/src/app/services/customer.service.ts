import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { configs } from '../config';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
    url = configs.BACKEND_BASE_URL + "/api/cliente"
    constructor( private httpClient:HttpClient ){}

    list() {
        return this.httpClient.get(this.url)
    }

    getOne(id: Number) {
        return this.httpClient.get(this.url + "/" + id)
    }

    insert(customer: any) {
        return this.httpClient.post(this.url, customer)
    }

    update(customer: any) {
        return this.httpClient.put(this.url, customer)
    }

    delete(id: Number) {
        return this.httpClient.get(this.url + "/" + id)
    }
}