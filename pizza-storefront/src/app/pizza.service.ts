// Implement the methods in PizzaService for Task 3
// Add appropriate parameter and return type 

import { HttpClient } from "@angular/common/http"
import { Injectable } from "@angular/core";

@Injectable()
export class PizzaService {

  constructor(private http:HttpClient) { }

  hostname = 'http://localhost:8080'

  headers = {
    'Content-Type': 'application/json',
    'Accept': 'application/json',
  }

  // POST /api/order
  // Add any required parameters or return type
  createOrder(reqBody:any) { 
    return this.http.post( this.hostname + "/api/order", reqBody, { headers: this.headers })
  }

  // GET /api/order/<email>/all
  // Add any required parameters or return type
  getOrders(email: string) { 
    return this.http.get( this.hostname + "/api/order/" + email + "/all", { headers: this.headers })
  }
}
