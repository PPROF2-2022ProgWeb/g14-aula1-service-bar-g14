import { Component, OnInit } from '@angular/core';
import { CartService } from '../../services/cart.service';
import { Product } from '../../interface/products';


@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit {

  products: Product[] = [];

  constructor( private cartService:CartService ) { }

  ngOnInit(): void {
    this.products = this.cartService.getCartProducts();
  }

  deleteItem(id:number){

    console.log('debo eliminar el producto con id', id);
    this.cartService.deleteProductById(id); //elimino el producto en el service
    this.products = this.cartService.getCartProducts(); //vuelvo a traer el producto del service pero ya con el elemento eliminado
  }



}
