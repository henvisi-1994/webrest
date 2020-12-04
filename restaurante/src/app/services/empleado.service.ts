import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Empleado } from '../models/Empleado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {
  API_URI = environment.API_URI; // URL de Backend
  constructor(private http: HttpClient, private router: Router) { }

  getEmpleados(){
    return this.http.get(`${this.API_URI}/empleados`);
  }

  getEmpleado(id_emp: number) {
    return this.http.get(`${this.API_URI}/empleados/${id_emp}`);
  }

  guardarEmpleado(empleado: Empleado) {
    return this.http.post(`${this.API_URI}/empleados`, empleado);
  }

  updateEmpleado(id_emp: number, updateEmpleado: Empleado) {
    return this.http.put(`${this.API_URI}/empleados/${id_emp}`, updateEmpleado);
  }

  deleteEmpleado(id_emp: number) {
    return this.http.delete(`${this.API_URI}/empleados/${id_emp}`);
  }


}
