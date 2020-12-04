import { Proveedor } from './../models/Proveedor';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class ProveedorService {
  API_URI = environment.API_URI; // URL de Backend
  constructor(private http: HttpClient, private router: Router) { }

  getProveedores(){
    return this.http.get(`${this.API_URI}/proveedores`);
  }

  getProveedor(id_prov: number) {
    return this.http.get(`${this.API_URI}/proveedores/${id_prov}`);
  }

  guardarProveedor(proveedor: Proveedor) {
    return this.http.post(`${this.API_URI}/proveedores`, proveedor);
  }

  updateProveedor(id_prov: number, updateProveedor: Proveedor) {
    return this.http.put(`${this.API_URI}/proveedores/${id_prov}`, updateProveedor);
  }

  deleteProveedor(id_prov: number) {
    return this.http.delete(`${this.API_URI}/proveedores/${id_prov}`);
  }

}
