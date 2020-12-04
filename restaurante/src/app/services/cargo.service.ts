import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Cargo } from '../models/Cargo';

@Injectable({
  providedIn: 'root'
})
export class CargoService {
  API_URI = environment.API_URI; // URL de Backend
  constructor(private http: HttpClient, private router: Router) { }

  getCargos(){
    return this.http.get(`${this.API_URI}/cargos`);
  }

  getCargo(id_cargo: number) {
    return this.http.get(`${this.API_URI}/cargos/${id_cargo}`);
  }

  guardarCargo(cargo: Cargo) {
    return this.http.post(`${this.API_URI}/cargos`, cargo);
  }

  updateCargo(id_cargo: number, updateCargo: Cargo) {
    return this.http.put(`${this.API_URI}/cargos/${id_cargo}`, updateCargo);
  }

  deleteCargo(id_cargo: number) {
    return this.http.delete(`${this.API_URI}/cargos/${id_cargo}`);
  }

}
