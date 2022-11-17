import { Injectable } from '@angular/core';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  // Este array guarda los productos del carrito
  private cartProducts: Product[] = [];

  constructor() { }

  addProduct( product:Product ){

    if( this.cartProducts.some( el => el.idProducto === product.idProducto ) ){
      // ya existe un producto con el mismo idProducto
      const newCart = this.cartProducts.map( prod => {//genero un nuevo array con productos del carrito pero con la qty modificada
        if(prod.idProducto === product.idProducto ){
          prod.qty = prod.qty! + product.qty!;
        }
        return prod;
      });
      this.cartProducts = newCart; //remplazo el nuevo array en el array original de productos de carrito

    }else{
      // no existe ningún producto en el carrito con el id del producto que quiero agregar
      this.cartProducts.push(product);
    }
    console.log(this.cartProducts);
    // TODO: Agregar la lógica para que no se repitan los productos, es decir, si ya tengo 2 unidades de una cerveza y le quiero añadir una cerveza más, lo que tengo que hacer es modificar la cantidad del producto y no duplicarlo.

  }

  getCartProducts(){
    return this.cartProducts;
  }

  deleteProductById(id:number){
    const newCart = this.cartProducts.filter( prod => prod.idProducto !== id );
    this.cartProducts = newCart;
  }

  deleteAllProducts(){
    this.cartProducts = [];
  }



}
