import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { configs } from '../config';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
    url = configs.BACKEND_BASE_URL + "/api/pedido"
    constructor( private httpClient:HttpClient ){}

    list() {
        return this.httpClient.get(this.url)
    }

    getOne(id: Number) {
        return this.httpClient.get(this.url + "/" + id)
    }

    insert(pedido: any) {
        return this.httpClient.post(this.url, pedido)
    }

    update(pedido: any) {
        return this.httpClient.put(this.url, pedido)
    }

    delete(id: Number) {
        return this.httpClient.get(this.url + "/" + id)
    }
}