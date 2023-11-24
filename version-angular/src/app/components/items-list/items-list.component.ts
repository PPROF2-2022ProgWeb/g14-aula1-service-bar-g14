import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProductService } from 'src/app/services/product.service';
import { Product } from '../../models/product';

@Component({
  selector: 'app-items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.css']
})
export class ItemsListComponent implements OnInit {

  products:Product[]=[];
  allProducts:Product[] = [];

  searchForm: FormGroup = this.formBuilder.group({

    search: ["", [Validators.required, Validators.minLength(2)]],

  });

  constructor( private productService:ProductService, private formBuilder: FormBuilder ){ }

  ngOnInit(): void { //método que se ejecuta a penas se monta el componente

    this.productService.list().subscribe( resp => {
      this.products = resp
      this.allProducts = resp
    } )

  }

  search() {
    this.products = this.products.filter(prod => prod.nombre.toLowerCase().includes(this.searchForm.value.search))
  }

  clearSearch() {
    this.products = this.allProducts
    this.searchForm.setValue({search: ''})
  }

}
