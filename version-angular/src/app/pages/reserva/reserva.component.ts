import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from "@angular/forms";
import { Router } from '@angular/router';
import { take } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';

import { BookingService } from 'src/app/services/booking.service';

@Component({
  selector: 'app-reserva',
  templateUrl: './reserva.component.html',
  styleUrls: ['./reserva.component.css']
})
export class ReservaComponent implements OnInit {

  errorMsg = ""

  idCliente = 0;

  reservaForm: FormGroup = this.formBuilder.group({
    date:["", [ Validators.required ]],
    time:["",[ Validators.required ]],
    persons:["",[ Validators.required, Validators.max(50)]]
  });

  constructor(private formBuilder: FormBuilder, private bookingService: BookingService, private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
    this.authService.loggedUser.pipe(
      take(1)
    ).subscribe(usr => {
      if(usr?.idCliente != null) {
        this.idCliente = usr.idCliente!
      }
    })
  }


  onSubmit(){
    this.errorMsg = ""
    console.log(this.reservaForm);
    console.log('datos obtenidos: ', this.reservaForm.value );
    const day = this.reservaForm.value.date.getDate()
    const month = this.reservaForm.value.date.getMonth() + 1
    const year = this.reservaForm.value.date.getFullYear()
    const time = this.reservaForm.value.time;
    const dateString = `${year}-${month}-${day}T${time}:00-03:00`
    const booking = {
      fecha: dateString,
      cantidadPersonas: this.reservaForm.value.persons,
      idCliente: this.idCliente
    }
    this.bookingService.insert(booking).subscribe({
      next: resp => this.successReserva(resp),
      error: error => this.errorReserva(error)
    })
  }

  successReserva(resp: any) {
    this.router.navigate(["lista-reservas"])
  }

  errorReserva(error: any) {
    this.errorMsg = "Error durante la creación de la reserva. Intente mas tarde."
  }

  goToBookings() {
    this.router.navigate(["lista-reservas"])
  }

}
