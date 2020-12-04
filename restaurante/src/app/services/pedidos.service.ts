import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Pedidos } from '../models/Pedidos';

@Injectable({
  providedIn: 'root'
})
export class PedidosService {
  API_URI = environment.API_URI; // URL de Backend
  constructor(private http: HttpClient, private router: Router) { }

  getPedidos(){
    return this.http.get(`${this.API_URI}/Pedidos`);
  }

  getPedido(id_pedido: number) {
    return this.http.get(`${this.API_URI}/Pedidos/${id_pedido}`);
  }

  guardarPedidos(pedidos: Pedidos) {
    return this.http.post(`${this.API_URI}/Pedidos`, pedidos);
  }

  updatePedidos(id_pedido: number, updatePedidos: Pedidos) {
    return this.http.put(`${this.API_URI}/Pedidos/${id_pedido}`, updatePedidos);
  }

  deletePedidos(id_pedido: number) {
    return this.http.delete(`${this.API_URI}/Pedidos/${id_pedido}`);
  }

}
