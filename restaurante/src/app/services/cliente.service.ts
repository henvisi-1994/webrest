import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Cliente } from '../models/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  API_URI = environment.API_URI; // URL de Backend
  constructor(private http: HttpClient, private router: Router) { }

  getClientes(){
    return this.http.get(`${this.API_URI}/clientes`);
  }

  getCliente(id_cli: String) {
    return this.http.get(`${this.API_URI}/clientes/${id_cli}`);
  }

  guardarCliente(cliente: Cliente) {
    return this.http.post(`${this.API_URI}/clientes`, cliente);
  }

  updateCliente(id_cli: String, updateCliente: Cliente) {
    return this.http.put(`${this.API_URI}/clientes/${id_cli}`, updateCliente);
  }

  deleteCliente(id_cli: String) {
    return this.http.delete(`${this.API_URI}/clientes/${id_cli}`);
  }

}
