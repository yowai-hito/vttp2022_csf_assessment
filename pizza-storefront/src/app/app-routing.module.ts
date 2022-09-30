import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './components/main.component';
import { OrdersComponent } from './components/orders/orders.component';

const routes: Routes = [
  
  { path : '',
    title: 'Landing Page',
    component: MainComponent
  },
  {
    path : 'orders/:email',
    title: 'Orders List',
    component: OrdersComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
