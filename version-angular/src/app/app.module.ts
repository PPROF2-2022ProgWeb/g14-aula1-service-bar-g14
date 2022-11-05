import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatMenuModule} from '@angular/material/menu';
import {MatTabsModule} from '@angular/material/tabs';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ItemsListComponent } from './components/items-list/items-list.component';
import { ItemComponent } from './components/item/item.component';
import { CartPageComponent } from './pages/cart-page/cart-page.component';
import { ProductsPagesComponent } from './pages/products-pages/products-pages.component';
import { HeaderComponent } from './components/header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './pages/login/login.component';
import { ReservaComponent } from './pages/reserva/reserva.component';
import { QuienesSomosComponent } from './pages/quienes-somos/quienes-somos.component';
import { ButtonPayComponent } from './components/button-pay/button-pay.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ItemsListComponent,
    ItemComponent,
    CartPageComponent,
    ProductsPagesComponent,
    HeaderComponent,
    LoginComponent,
    ReservaComponent,
    QuienesSomosComponent,
    ButtonPayComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatButtonModule,
    MatTabsModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatMenuModule,
    MatNativeDateModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
