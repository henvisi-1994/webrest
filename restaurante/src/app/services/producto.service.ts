import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Producto } from '../models/Producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  API_URI = environment.API_URI; // URL de Backend
  constructor(private http: HttpClient, private router: Router) { }

  getProductos(){
    return this.http.get(`${this.API_URI}/Producto`);
  }

  getProducto(id_producto: String) {
    return this.http.get(`${this.API_URI}/Producto/${id_producto}`);
  }

  guardarProducto(producto: Producto) {
    return this.http.post(`${this.API_URI}/Producto`, producto);
  }

  updateProducto(id_producto: String, updateProducto: Producto) {
    return this.http.put(`${this.API_URI}/Producto/${id_producto}`, updateProducto);
  }

  deleteProducto(id_producto: String) {
    return this.http.delete(`${this.API_URI}/Producto/${id_producto}`);
  }

}
