import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MpPreferenceResp } from '../../interface/MercadoPago';
import { Router } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { mpItem } from 'src/app/models/mpItem';
@Component({
  selector: 'app-button-pay',
  templateUrl: './button-pay.component.html',
  styleUrls: ['./button-pay.component.css']
})
export class ButtonPayComponent implements OnInit {

  constructor(private httpClient: HttpClient,
    private cartService: CartService,
    private router: Router
  ) { }

  mpUrl = "https://api.mercadopago.com/checkout/preferences";
  data = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization:
        "Bearer TEST-6637624312795887-101921-f8b88e1e85fea946fedf9f5ad7a2e854-1221314198"
    },
    body: JSON.stringify({
      items: this.getItems(),
      auto_return: "approved",
      back_urls: { success: "https://1ic3u.csb.app/" }
    })
  };
  ngOnInit(): void {

  }

  async payNow() {
    console.log(this.data);
    const resp: MpPreferenceResp = await fetch(this.mpUrl, this.data).then(resp => resp.json());

    console.log(resp.sandbox_init_point);
    window.open(resp.sandbox_init_point, "_blank")
  }

  getItems() {
    // return [
    //   {
    //     title: "Dummy Title",
    //     description: "Dummy description",
    //     picture_url:
    //       "https://www.digitalsport.com.ar/files/products/61018b1d0af10-556975-500x500.jpg",
    //     category_id: "cat123",
    //     quantity: 2,
    //     currency_id: "ARS",
    //     unit_price: 10
    //   }
    // ]

    const items: mpItem[] = this.cartService.getCartProducts().map(
      prod => {
        return {
          title: prod.nombre,
          description: "Dummy description",
          picture_url: prod.urlImagen,
          category_id: "cat123",
          quantity: prod.qty!,
          currency_id: "ARS",
          unit_price: prod.precio
        }
      }


    )
    return items;
    }


}
