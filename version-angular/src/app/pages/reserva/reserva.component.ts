import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from "@angular/forms";

@Component({
  selector: 'app-reserva',
  templateUrl: './reserva.component.html',
  styleUrls: ['./reserva.component.css']
})
export class ReservaComponent implements OnInit {

  reservaForm: FormGroup = this.formBuilder.group({
    date:["", [ Validators.required ]],
    time:["",[ Validators.required ]],
    persons:["",[ Validators.required]]
  });

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }


  onSubmit(){

    console.log(this.reservaForm);
    console.log('datos obtenidos: ', this.reservaForm.value );
  }

}
