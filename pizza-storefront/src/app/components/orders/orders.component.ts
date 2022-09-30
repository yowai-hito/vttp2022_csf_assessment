import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { firstValueFrom, Observable, switchMap } from 'rxjs';
import { PizzaService } from 'src/app/pizza.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  pizzaObs$ !: Observable<any>;
  orderData !: Array<any>;

  constructor(private route: ActivatedRoute, private pizzaSvc: PizzaService) { }

  ngOnInit(): void {
    this.pizzaObs$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) => 
        this.pizzaSvc.getOrders(params.get('email')!))
    );

    firstValueFrom(this.pizzaObs$)
    .then((resp)=> {
      console.log(resp)
      this.orderData = resp
    })
  }
}
