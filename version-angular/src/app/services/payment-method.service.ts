import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { configs } from '../config';

@Injectable({
  providedIn: 'root'
})
export class PaymentMethodService {
    url = configs.BACKEND_BASE_URL + "/api/metodo-pago"
    constructor( private httpClient:HttpClient ){}

    list() {
        return this.httpClient.get(this.url)
    }

    getOne(id: Number) {
        return this.httpClient.get(this.url + "/" + id)
    }

    insert(metodoPago: any) {
        return this.httpClient.post(this.url, metodoPago)
    }

    update(metodoPago: any) {
        return this.httpClient.put(this.url, metodoPago)
    }

    delete(id: Number) {
        return this.httpClient.get(this.url + "/" + id)
    }
}