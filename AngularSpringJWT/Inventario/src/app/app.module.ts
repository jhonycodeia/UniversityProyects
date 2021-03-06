import { InventarioService } from './inventario/inventario.service';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
/*Config*/
import { AppRoutingModule } from './app-routing.module';
/*Component*/
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ClienteComponent } from './cliente/cliente.component';
import { ContactoComponent } from './contacto/contacto.component';
import { InventarioComponent } from './inventario/inventario.component';
import { InventarioDetalleComponent } from './inventario/inventario-detalle/inventario-detalle.component';
import { InventarioListaComponent } from './inventario/inventario-lista/inventario-lista.component';
/*Help*/
import { HeaderInterceptor } from './help/header.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ClienteComponent,
    ContactoComponent,
    InventarioComponent,
    InventarioDetalleComponent,
    InventarioListaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HeaderInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
