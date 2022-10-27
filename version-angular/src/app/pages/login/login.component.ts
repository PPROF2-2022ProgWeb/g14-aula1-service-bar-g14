import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  loginForm: FormGroup = this.formBuilder.group({

    email:["juan.cruz@gmail.com",[Validators.required, Validators.minLength(2), Validators.email]],
    password:["Abc123",[Validators.required, Validators.minLength(6)]]

  });

  registerForm: FormGroup = this.formBuilder.group({
    fname:["juan",[Validators.required, Validators.minLength(2)]],
    user:["juan.cruz@gmail.com",[Validators.required, Validators.minLength(2)]],
    password:["123456",[Validators.required, Validators.minLength(6)]]
  });

  constructor( private formBuilder: FormBuilder, private authService:AuthService ){}

  ngOnInit(): void {
  }

  login(){
    console.log(this.loginForm);
    if(this.loginForm.valid){
      // acá voy a ejecutar el servicio de login
      this.authService.login(this.loginForm.value).subscribe(resp=> console.log(resp));
    }else{
      //Acá voy a ejecutar algo cuando uno de los campos no es correcto
    }
  }

  register(){
    console.log(this.registerForm);
  }

}
