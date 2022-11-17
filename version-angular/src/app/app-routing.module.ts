import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProductsPagesComponent } from './pages/products-pages/products-pages.component';
import { CartPageComponent } from './pages/cart-page/cart-page.component';
import { LoginComponent } from './pages/login/login.component';
import { ReservaComponent } from './pages/reserva/reserva.component';
import { QuienesSomosComponent } from './pages/quienes-somos/quienes-somos.component';
import { ListaReservasComponent } from './pages/lista-reservas/lista-reservas.component';
import { AdminComponent } from './pages/admin/admin.component';
import { AdminProductListComponent } from './pages/admin-product-list/admin-product-list.component';
import { AdminAddProductComponent } from './pages/admin-add-product/admin-add-product.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'iniciar-sesion',
    component: LoginComponent,
  },
  {
    path: 'quienes-somos',
    component: QuienesSomosComponent,
  },
  {
    path: 'productos',
    component: ProductsPagesComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'reserva',
    component: ReservaComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'cart',
    component: CartPageComponent,
    canActivate: [AuthGuard]
  },

  {
    path: 'lista-reservas',
    component: ListaReservasComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'admin',
    component: AdminComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'admin-productos',
    component: AdminProductListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'admin-agregar-producto',
    component: AdminAddProductComponent,
    canActivate: [AuthGuard]
  }

  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
