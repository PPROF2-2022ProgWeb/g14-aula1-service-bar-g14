import { Component, OnInit } from '@angular/core';
import { BookingService } from '../../services/booking.service';
import { Product } from '../../interface/products';
import { Booking } from 'src/app/models/booking';


@Component({
  selector: 'app-lista-reservas',
  templateUrl: './lista-reservas.component.html',
  styleUrls: ['./lista-reservas.component.css']
})
export class ListaReservasComponent implements OnInit {

    reservas: Array<Booking> = []
  constructor( private bookingService:BookingService ) { }

  ngOnInit(): void {
    this.bookingService.list().subscribe(
        reservas => this.reservas = reservas.map(res => {
            return {...res, fecha: new Date(res.fecha).toLocaleString()}
        })
    )
  }

  deleteItem(id:number){
    this.bookingService.delete(id).subscribe(resp=> {
        this.bookingService.list().subscribe(
            reservas => this.reservas = reservas.map(res => {
                return {...res, fecha: new Date(res.fecha).toLocaleString()}
            })
        )
    })
  }



}
