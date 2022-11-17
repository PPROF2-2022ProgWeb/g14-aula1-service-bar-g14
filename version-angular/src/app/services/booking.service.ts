import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { configs } from '../config';
import { Booking } from '../models/booking';
import { AuthService } from './auth.service';
@Injectable({
  providedIn: 'root'
})
export class BookingService {
    url = configs.BACKEND_BASE_URL + "/api/reserva"
    idCliente = 0
    constructor( private httpClient:HttpClient, private authService: AuthService ){
        this.authService.loggedUser.subscribe(usr => {
            if(usr != null) {
                this.idCliente = usr.idCliente
            }
        })
    }

    list() {
        return this.httpClient.get<Array<Booking>>(this.url + "?idCliente=" + this.idCliente)
    }

    getOne(id: Number) {
        return this.httpClient.get(this.url + "/" + id)
    }

    insert(reserva: any) {
        return this.httpClient.post(this.url, reserva)
    }

    update(reserva: any) {
        return this.httpClient.put(this.url, reserva)
    }

    delete(id: Number) {
        return this.httpClient.delete(this.url + "/" + id)
    }
}