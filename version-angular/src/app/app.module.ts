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
import { ListaReservasComponent } from './pages/lista-reservas/lista-reservas.component';
import { QuienesSomosComponent } from './pages/quienes-somos/quienes-somos.component';
import { ButtonPayComponent } from './components/button-pay/button-pay.component';
import { ErrorDisplayComponent } from './components/error-display/error-display.component'
import { httpInterceptorProviders } from './http/http.interceptor';
import { AdminComponent } from './pages/admin/admin.component';
import { AdminProductListComponent } from './pages/admin-product-list/admin-product-list.component';
import { AdminAddProductComponent } from './pages/admin-add-product/admin-add-product.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    AdminProductListComponent,
    AdminAddProductComponent,
    HomeComponent,
    ItemsListComponent,
    ItemComponent,
    CartPageComponent,
    ProductsPagesComponent,
    HeaderComponent,
    LoginComponent,
    ReservaComponent,
    ListaReservasComponent,
    QuienesSomosComponent,
    ButtonPayComponent,
    ErrorDisplayComponent,
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
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
