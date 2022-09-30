import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';
import { firstValueFrom } from 'rxjs';
import { PizzaService } from '../pizza.service';

const SIZES: string[] = [
  "Personal - 6 inches",
  "Regular - 9 inches",
  "Large - 12 inches",
  "Extra Large - 15 inches"
]

const PizzaToppings: string[] = [
    'chicken', 'seafood', 'beef', 'vegetables',
    'cheese', 'arugula', 'pineapple'
]

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  pizzaSize = SIZES[0]
  pizzaOrder !: FormGroup
  pizzaToppings !:FormGroup

  constructor(private fb: FormBuilder, private pizzaSvc: PizzaService) {}

  ngOnInit(): void {
    this.pizzaToppings = this.pizzaToppingsInit()
    this.pizzaOrder = this.fb.group({
      userName: this.fb.control<string>('', [ Validators.required ]),
      userEmail: this.fb.control<string>('', [ Validators.required, Validators.email ]),
      userPizzaSize: this.fb.control<number>(0, [ Validators.required ]),
      userPizzaBase: this.fb.control<string>("thin", [ Validators.required ]),
      userPizzaSauce: this.fb.control<string>("classic", [ Validators.required ]),
      userPizzaToppings: this.fb.group(this.pizzaToppings.controls),
      userComments: this.fb.control<string>('')
    })
  }

  public get pizzaToppingsControl() {
    return this.pizzaOrder.controls["userPizzaToppings"];
  }
  
  pizzaToppingsInit():FormGroup {
    const toppingsList: FormGroup = this.fb.group({
      chicken: this.fb.control<boolean>(false),
      seafood: this.fb.control<boolean>(false),
      beef: this.fb.control<boolean>(false),
      vegetables: this.fb.control<boolean>(false),
      cheese: this.fb.control<boolean>(false),
      arugula: this.fb.control<boolean>(false),
      pineapple: this.fb.control<boolean>(false),
    })
    return toppingsList;
  }

  updateSize(size: string) {
    this.pizzaSize = SIZES[parseInt(size)]
  }

  submitOrder() {
    console.log(this.pizzaOrder.value)
    const resp = this.pizzaSvc.createOrder(this.pizzaOrder.value)
    firstValueFrom(resp).then((response:any)=> {
      console.log(response.data)
    })
  }

}
