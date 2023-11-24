import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';


@Component({
  selector: 'app-admin-add-product',
  templateUrl: './admin-add-product.component.html',
  styleUrls: ['./admin-add-product.component.css']
})
export class AdminAddProductComponent implements OnInit {
  prodErrorMsg = ""
  productForm: FormGroup = this.formBuilder.group(
    {
      nombre: ["", [Validators.required, Validators.minLength(3)]],
      precio: [0, [Validators.required, Validators.min(0)]],
      stockAct: [0, [Validators.required, Validators.min(0)]],
      stockMin: [0, [Validators.required, Validators.min(0)]],
      stockMax: [0, [Validators.required, Validators.min(0)]],
      urlImagen: ["", [Validators.required, Validators.minLength(3)]]
    }
  )

  constructor(private formBuilder: FormBuilder, private productService: ProductService, private router: Router) {

  }

  ngOnInit(): void {

  }

  addProduct() {
    this.prodErrorMsg = ""
    this.productService.insert(this.productForm.value).subscribe(
      {
        next: resp => this.router.navigate(['admin-productos']),
        error: error => this.prodErrorMsg = "Error al grabar producto"
      }
    )
  }

}