import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { PedidoProveedor } from '../models/PedidoProveedor';

@Injectable({
  providedIn: 'root'
})
export class PedidoProveedorService {
  API_URI = environment.API_URI; // URL de Backend
  constructor(private http: HttpClient, private router: Router) { }

  getPedidoProveedores(){
    return this.http.get(`${this.API_URI}/PedidoProveedor`);
  }

  getPedidoProveedor(id_dedido_prov: number) {
    return this.http.get(`${this.API_URI}/PedidoProveedor/${id_dedido_prov}`);
  }

  guardarPedidoProveedor(pedidoproveedor: PedidoProveedor) {
    return this.http.post(`${this.API_URI}/PedidoProveedor`, pedidoproveedor);
  }

  updatePedidoProveedor(id_dedido_prov: number, updatePedidoProveedor: PedidoProveedor) {
    return this.http.put(`${this.API_URI}/PedidoProveedor/${id_dedido_prov}`, updatePedidoProveedor);
  }

  deletePedidoProveedor(id_dedido_prov: number) {
    return this.http.delete(`${this.API_URI}/PedidoProveedor/${id_dedido_prov}`);
  }

}
