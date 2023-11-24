import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginErrorMsg = "";
  signupErrorMsg = "";

  registroExitoso = false;

  loginForm: FormGroup = this.formBuilder.group({

    email: ["", [Validators.required, Validators.minLength(2), Validators.email]],
    password: ["", [Validators.required, Validators.minLength(6)]]

  });

  registerForm: FormGroup = this.formBuilder.group({
    nombre: ["", [Validators.required, Validators.minLength(3)]],
    apellido: ["", [Validators.required, Validators.minLength(3)]],
    dni: ["", [Validators.required, Validators.minLength(8)]],
    telefono: ["", [Validators.required, Validators.minLength(6)]],
    direccion: ["", [Validators.required, Validators.minLength(8)]],
    email: ["", [Validators.required, Validators.minLength(3), Validators.email]],
    password: ["", [Validators.required, Validators.minLength(6)]],
    repassword: ["", [Validators.required, Validators.minLength(6)]],
  });

  constructor(private formBuilder: FormBuilder, private authService: AuthService,
    private router: Router,
    private productService: ProductService) { }

  ngOnInit(): void {
  }

  login() {
    this.loginErrorMsg = ""
    console.log(this.loginForm);
    if (this.loginForm.valid) {
      // acá voy a ejecutar el servicio de login
      const payload = { username: this.loginForm.value.email, password: this.loginForm.value.password };
      this.authService.login(payload).subscribe({
        next: resp => this.successFullLogin(resp),
        error: error => this.errorLogin(error)
      })
    } else {
      //Acá voy a ejecutar algo cuando uno de los campos no es correcto
    }
  }

  successFullLogin(resp: any) {
    console.log(resp);

    this.router.navigate([''])

    this.productService.list().subscribe(prods => console.log(prods));

  }

  errorLogin(error: any) {
    if (error && error.status == 401) {
      this.loginErrorMsg = "Usuario o contraseña incorrecta."
    }
    else {
      this.loginErrorMsg = "Error durante el login."
    }
  }

  register() {
    this.signupErrorMsg = ""
    console.log(this.registerForm)

    this.authService.signup(this.registerForm.value).subscribe({
      next: resp => this.successFullSignup(resp),
      error: error => this.errorSignup(error)
    })
  }

  successFullSignup(resp: any) {
    this.registroExitoso = true;
    this.router.navigate([''])
  }

  errorSignup(error: any) {
    this.signupErrorMsg = "Error durante el registro, reintente más tarde." 
  }

}
