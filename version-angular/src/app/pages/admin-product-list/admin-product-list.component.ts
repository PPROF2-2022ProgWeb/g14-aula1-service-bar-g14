import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin-product-list.component.html',
  styleUrls: ['./admin-product-list.component.css']
})
export class AdminProductListComponent implements OnInit {
  products: Product[] = []

  constructor(private productService: ProductService) {

  }

    ngOnInit(): void {
      this.productService.list().subscribe(prods => this.products = prods)    
    }

    deleteItem(id: number) {
      this.productService.delete(id)
        .subscribe(resp => {
          this.productService.list().subscribe(prods => this.products = prods)    
        })
    }

}