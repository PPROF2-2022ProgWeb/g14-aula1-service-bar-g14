import { Component, Input, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { Product } from '../../models/product';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {
  @Input() item: Product = {
    nombre:'',
    precio:0,
    urlImagen: '',
    stockAct:0,
    stockMin: 0,
    stockMax: 0,
    idProducto: 0
  };

  qty:number=1;

  constructor( private cartService: CartService ) {
  }

  ngOnInit(): void {
  }

  addProduct(qty:number){
    // this.qty = this.qty + qty;
    this.qty += qty;
  }

  addToCart(){
    console.log('click');
    this.cartService.addProduct({ ...this.item, qty: this.qty })
  }

}
