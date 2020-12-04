import { Cargo } from './../../../models/Cargo';
import { CargoService } from './../../../services/cargo.service';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-cargos',
  templateUrl: './cargos.component.html',
  styleUrls: ['./cargos.component.css']
})
export class CargosComponent implements OnInit {

  closeResult: string;
  @ViewChild('cargosModal', {static: false}) modal: ElementRef;
  edit = false;
  cargo: Cargo = {
    id_cargo: 0,
    nombre_cargo: ''
  };
  cargos: any;
  constructor(private modalService: NgbModal,private cargoService: CargoService) { }

  ngOnInit(): void {
    this.getcargos();
  }
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
getcargos() {
  this.cargoService.getCargos().subscribe(
    (res: any) => {
      this.cargos = res;
    },
    err => {

    }
  );
}

public editcargo(cargo: Cargo) {
  this.cargo.id_cargo = cargo.id_cargo;
  this.cargo.nombre_cargo = cargo.nombre_cargo;
  this.edit = true;
  this.modalService.open(this.modal);
}
// tslint:disable-next-line: variable-name
public borrarcargo(id_cargo: number) {
  this.cargoService.deleteCargo(id_cargo).subscribe(
    (res: any) => {
        this.getcargos();
    },
    err => {
    }
  );
}
public savecargo() {
  this.cargoService.guardarCargo(this.cargo).subscribe(
    (res: any) => {
      this.getcargos();
      this.modalService.dismissAll();
    },
    err => {
    }
  );
}
public updatecargo() {
 this.cargoService.updateCargo(this.cargo.id_cargo, this.cargo).subscribe(
    (res: any) => {
      this.getcargos();
      this.modalService.dismissAll();
    },
    err => {
    }
  );
}
public guardarcargo() {
  (this.edit ? this.updatecargo() : this.savecargo());
}
}
