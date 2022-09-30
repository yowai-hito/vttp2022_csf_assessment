import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MainComponent } from './components/main.component';
import { PizzaService } from './pizza.service';
import { OrdersComponent } from './components/orders/orders.component';
import { AppRoutingModule } from './app-routing.module';


@NgModule({
  declarations: [
    AppComponent, MainComponent, OrdersComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],

  providers: [PizzaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
