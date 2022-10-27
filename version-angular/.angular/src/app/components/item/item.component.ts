import { Component, Input, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { Product } from '../../interface/products';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {
  @Input() item: Product = {
    name:'',
    price:0,
    thumbnail:'',
    size: '',
    stock:0,
    description:'',
    vendor:'',
    category:'',
    id:0
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
