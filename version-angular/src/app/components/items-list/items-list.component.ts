import { Component, OnInit } from '@angular/core';
import { Product } from '../../interface/products';
import { BackendService } from '../../services/backend.service';

@Component({
  selector: 'app-items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.css']
})
export class ItemsListComponent implements OnInit {

  products:Product[]=[];

  constructor( private backendService:BackendService ){ }

  ngOnInit(): void { //método que se ejecuta a penas se monta el componente

    this.backendService.getProducts().subscribe( resp => this.products = resp.products )

  }

}
