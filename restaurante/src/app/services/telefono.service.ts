import { Telefono } from './../models/Telefono';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class TelefonoService {
  API_URI = environment.API_URI; // URL de Backend
  constructor(private http: HttpClient, private router: Router) { }

  getTelefonos(){
    return this.http.get(`${this.API_URI}/Telefono`);
  }

  getTelefono(id_telefono: number) {
    return this.http.get(`${this.API_URI}/Telefono/${id_telefono}`);
  }

  guardarTelefono(telefono: Telefono) {
    return this.http.post(`${this.API_URI}/Telefono`, telefono);
  }

  updateTelefono(id_telefono: number, updateTelefono: Telefono) {
    return this.http.put(`${this.API_URI}/Telefono/${id_telefono}`, updateTelefono);
  }

  deleteTelefono(id_telefono: number) {
    return this.http.delete(`${this.API_URI}/Telefono/${id_telefono}`);
  }

}
