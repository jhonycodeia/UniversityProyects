import { Router, ActivatedRoute, Params } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { InventarioService } from './../inventario.service';
import { Inventario } from '../inventario';
import { InventarioValidator } from '../inventario.validators';




@Component({
  selector: 'app-inventario-detalle',
  templateUrl: './inventario-detalle.component.html',
  styleUrls: ['./inventario-detalle.component.css']
})
export class InventarioDetalleComponent implements OnInit {

  titulo = 'Modulo de productos';
  message: object;
  form: FormGroup;
  inventario: Inventario;
  editar = false;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private inventarioService: InventarioService,
    private formBuilder: FormBuilder) {
    this.createControles();
  }

  ngOnInit() {
    let id = this.activatedRoute.snapshot.params['id'];
    if (!id) {


    }
    else {
      this.inventarioService.getInventarioById(id).subscribe(
        data => this.inventario = data,
        error => console.log(error),
        () => {
          this.form.patchValue({
            id: this.inventario.id,
            producto: this.inventario.producto,
            existencias: this.inventario.existencias,
            precio: this.inventario.precio,
            proveedor: this.inventario.proveedor
          });
          this.editar = true;
        });
      console.log(id);
      this.form.controls.id.disable();
    }
  }

  createControles() {
    this.form = this.formBuilder.group({
      id: ['', Validators.required, InventarioValidator.valorUnico(this.inventarioService)],
      producto: ['', Validators.compose([Validators.required, Validators.maxLength(10)])],
      existencias: ['', Validators.required],
      precio: ['', Validators.required],
      proveedor: ['', Validators.required]
    });

  }

  create() {
    this.inventarioService.createInventario(this.form.value).subscribe(data => this.message = data);
    this.limpiar();
  }

  update() {

    let link = ['/inventario/lista'];
    let json = this.form.value;
    json.id = this.form.controls.id.value;
    this.inventarioService.updateInventario(json).subscribe(data => this.message = data);
    this.router.navigate(link);

    console.log(json);

  }

  limpiar() {
    console.log(this.form);
    this.form.reset();
  }

}
