import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
/*Component*/
import { ContactoComponent } from './contacto/contacto.component';
import { InventarioComponent } from './inventario/inventario.component';
import { ClienteComponent } from './cliente/cliente.component';
import { HomeComponent } from './home/home.component';
/*Children component*/
import { InventarioDetalleComponent } from './inventario/inventario-detalle/inventario-detalle.component';
import { InventarioListaComponent } from './inventario/inventario-lista/inventario-lista.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'cliente', component: ClienteComponent },
  {
    path: 'inventario', component: InventarioComponent,
    children: [
      { path: '', redirectTo: 'lista', pathMatch: 'full' },
      { path: 'lista', component: InventarioListaComponent },
      { path: 'detalle', component: InventarioDetalleComponent },
      { path: 'detalle/:id', component: InventarioDetalleComponent }
    ]
  },
  { path: 'contacto', component: ContactoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
