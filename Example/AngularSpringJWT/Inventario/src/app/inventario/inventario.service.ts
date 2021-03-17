import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Inventario } from './inventario';


@Injectable({
  providedIn: 'root'
})
export class InventarioService {

  private url = 'http://localhost:8090/inventario';

  constructor(private http: HttpClient) { }

  public getInventarioAll() {
    return this.http.get<Inventario[]>(this.url + '/all');
  }

  public getInventarioById(id: number) {
    return this.http.get<Inventario>(this.url + '/get/' + id);
  }

  public createInventario(inventario: Inventario) {
    return this.http.post(this.url + '/add', JSON.stringify(inventario));
  }

  public updateInventario(inventario: Inventario) {
    return this.http.put(this.url + '/update', JSON.stringify(inventario));
  }

  public deleteInventario(id: number) {
    return this.http.delete(this.url + '/delete/' + id);
  }

  public deleteInventarioAll() {
    return this.http.delete(this.url + '/delete');
  }





}
