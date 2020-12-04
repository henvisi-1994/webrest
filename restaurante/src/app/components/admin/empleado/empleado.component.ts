import { EmpleadoService } from './../../../services/empleado.service';
import { Empleado } from './../../../models/Empleado';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
  styleUrls: ['./empleado.component.css']
})
export class EmpleadoComponent implements OnInit {

  closeResult: string;
  @ViewChild('empleadoModal', {static: false}) modal: ElementRef;
  edit = false;
  empleado: Empleado = {
    id_emp: 0,
  nombre_emp: '',
  dir_emp: '',
  tel_emp: '',
  id_local: 0,
  id_usuario: 0,
  id_cargo: 0,
  };
  empleados: any;
  constructor(private modalService: NgbModal, private empleadoService: EmpleadoService) { }
  ngOnInit(): void { }
  // Boton para abrir ventana modal
  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
// Cierra Ventana modal
private getDismissReason(reason: any): string {
  if (reason === ModalDismissReasons.ESC) {
    return 'by pressing ESC';
  } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
    return 'by clicking on a backdrop';
  } else {
    return  `with: ${reason}`;
  }
}
// Lena arreglo de productos
getempleados() {
  this.empleadoService.getEmpleados().subscribe(
    (res: any) => {
      this.empleados = res;
    },
    err => {

    }
  );
}

public editempleado(empleado: Empleado) {
  this.empleado.id_emp = empleado.id_emp;
  this.empleado.nombre_emp = empleado.nombre_emp;
  this.edit = true;
  this.modalService.open(this.modal);
}
// tslint:disable-next-line: variable-name
public borrarempleado(id_empleado: number) {
  this.empleadoService.deleteEmpleado(id_empleado).subscribe(
    (res: any) => {
        this.getempleados();
    },
    err => {
    }
  );
}
public saveempleado() {
  this.empleadoService.guardarEmpleado(this.empleado).subscribe(
    (res: any) => {
      this.getempleados();
      this.modalService.dismissAll();
    },
    err => {
    }
  );
}
public updateempleado() {
 this.empleadoService.updateEmpleado(this.empleado.id_emp, this.empleado).subscribe(
    (res: any) => {
      this.getempleados();
      this.modalService.dismissAll();
    },
    err => {
    }
  );
}
public guardarempleado() {
  (this.edit ? this.updateempleado() : this.saveempleado());
}
}
