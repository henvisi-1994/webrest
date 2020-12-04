import { Cliente } from './../../../models/Cliente';
import { ClienteService } from './../../../services/cliente.service';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {
  closeResult: string;
  @ViewChild('clienteModal', {static: false}) modal: ElementRef;
  edit = false;
  cliente: Cliente = {
    id_cli: '',
  nom_cli: '',
  ape_cli: '',
  tel_cli: '',
  dir_cli: '',
  };
  clientes: any;
  constructor(private modalService: NgbModal, private clienteService: ClienteService) { }

  ngOnInit(): void {
    this.getclientes();
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
getclientes() {
  this.clienteService.getClientes().subscribe(
    (res: any) => {
      this.clientes = res;
    },
    err => {

    }
  );
}

public editcliente(cliente: Cliente) {
  this.cliente.id_cli = cliente.id_cli;
  this.cliente.nom_cli = cliente.nom_cli;
  this.cliente.ape_cli = cliente.ape_cli;
  this.cliente.tel_cli = cliente.tel_cli;
  this.cliente.dir_cli = cliente.dir_cli;
  this.edit = true;
  this.modalService.open(this.modal);
}
// tslint:disable-next-line: variable-name
public borrarcliente(id_cli: string) {
  this.clienteService.deleteCliente(id_cli).subscribe(
    (res: any) => {
        this.getclientes();
    },
    err => {
    }
  );
}
public savecliente() {
  this.clienteService.guardarCliente(this.cliente).subscribe(
    (res: any) => {
      this.getclientes();
      this.modalService.dismissAll();
    },
    err => {
    }
  );
}
public updatecliente() {
 this.clienteService.updateCliente(this.cliente.id_cli, this.cliente).subscribe(
    (res: any) => {
      this.getclientes();
      this.modalService.dismissAll();
    },
    err => {
    }
  );
}
public guardarcliente() {
  (this.edit ? this.updatecliente() : this.savecliente());
}


}
