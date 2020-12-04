import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Telefono } from 'src/app/models/Telefono';
import { TelefonoService } from 'src/app/services/telefono.service';

@Component({
  selector: 'app-telefono',
  templateUrl: './telefono.component.html',
  styleUrls: ['./telefono.component.css']
})
export class TelefonoComponent implements OnInit {

  closeResult: string;
  @ViewChild('telefonoModal', {static: false}) modal: ElementRef;

  edit = false;
  telefono: Telefono = {
    id_telefono: 0,
    numero_telf: '',
    id_local: 0,
  };
  telefonos: any;
  constructor(private modalService: NgbModal, private telefonoService: TelefonoService) { }

  ngOnInit(): void {
    this.getTelefonos();
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
getTelefonos() {
  this.telefonoService.getTelefonos().subscribe(
    (res: any) => {
      this.telefono = res;
    },
    err => {

    }
  );
}

public editTelefono(telefono: Telefono) {
  this.telefono.numero_telf= telefono.numero_telf;
  this.telefono.id_local= telefono.id_local;
  this.edit = true;
  this.modalService.open(this.modal);
}

public borrarTelefono(id_telefono: number) {
  this.telefonoService.deleteTelefono(id_telefono).subscribe(
    (res: any) => {
        this.getTelefonos();
    },
    err => {
    }
  );
}

public saveTelefono() {
  this.telefonoService.guardarTelefono(this.telefono).subscribe(
    (res: any) => {
      this.getTelefonos();
    },
    err => {
    }
  );
}

public updateTelefono() {
  this.telefonoService.updateTelefono(this.telefono.id_telefono, this.telefono).subscribe(
    (res: any) => {
      this.getTelefonos();
    },
    err => {

    }
  );
}
public guardarTelefono() {
  (this.edit ? this.updateTelefono() : this.saveTelefono());
}

}
