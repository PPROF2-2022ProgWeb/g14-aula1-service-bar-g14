import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  nombre = "";
  isAdmin = true;
  constructor(
    private router:Router,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    this.authService.loggedUser.subscribe(user  => {
      if(user != null) {
        
        this.nombre = user.nombre
        this.isAdmin = user.roles.some(role => role == "ROLE_ADMIN")
      }
      else {
        this.nombre = ""
      }
    })
  }
  goToCart(){
    this.router.navigate(['/cart'])
  }

  signout() {
    this.authService.signout();
    this.router.navigate(['iniciar-sesion'])
  }

  isSignedIn() {
    return this.nombre != '';
  }

}
