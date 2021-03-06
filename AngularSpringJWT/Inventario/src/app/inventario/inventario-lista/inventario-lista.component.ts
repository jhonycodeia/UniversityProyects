import { Router } from '@angular/router';
import { InventarioService } from './../inventario.service';
import { Component, OnInit } from '@angular/core';
import { Inventario } from '../inventario';


@Component({
  selector: 'app-inventario-lista',
  templateUrl: './inventario-lista.component.html',
  styleUrls: ['./inventario-lista.component.css']
})
export class InventarioListaComponent implements OnInit {

  message: object;
  productos: Inventario[];

  constructor(
    private inventarioService: InventarioService,
    private router: Router) { }

  ngOnInit() {
    this.inventarioService.getInventarioAll().subscribe(data => this.productos = data);
  }

  selecionar(id) {
    let link = ['/inventario/detalle', id];
    this.router.navigate(link);
  }

  borrar(id) {
    this.inventarioService.deleteInventario(id).subscribe(
      data => this.message = data,
      error => console.log(error),
      () => this.inventarioService.getInventarioAll().subscribe(data => this.productos = data));

  }

}
