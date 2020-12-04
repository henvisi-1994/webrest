import { ProveedorService } from './../../../services/proveedor.service';
import { Proveedor } from './../../../models/Proveedor';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-proveedores',
  templateUrl: './proveedores.component.html',
  styleUrls: ['./proveedores.component.css']
})
export class ProveedoresComponent implements OnInit {

  closeResult: string;
  @ViewChild('proveedorModal', {static: false}) modal: ElementRef;
  edit = false;
  proveedor: Proveedor = {
    id_prov: 0,
    nom_prov: '',
    id_local: 0,
  };
  proveedores: any;
  constructor(private modalService: NgbModal, private proveedoresService: ProveedorService) { }
  ngOnInit(): void {

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
getproveedores() {
  this.proveedoresService.getProveedores().subscribe(
    (res: any) => {
      this.proveedores = res;
    },
    err => {

    }
  );
}

public editproveedor(proveedor: Proveedor) {
  this.proveedor.id_prov = proveedor.id_prov;
  this.proveedor.nom_prov = proveedor.nom_prov;
  this.edit = true;
  this.modalService.open(this.modal);
}
// tslint:disable-next-line: variable-name
public borrarproveedor(id_proveedor: number) {
  this.proveedoresService.deleteProveedor(id_proveedor).subscribe(
    (res: any) => {
        this.getproveedores();
    },
    err => {
    }
  );
}
public saveproveedor() {
  this.proveedoresService.guardarProveedor(this.proveedor).subscribe(
    (res: any) => {
      this.getproveedores();
      this.modalService.dismissAll();
    },
    err => {
    }
  );
}
public updateproveedor() {
 this.proveedoresService.updateProveedor(this.proveedor.id_prov, this.proveedor).subscribe(
    (res: any) => {
      this.getproveedores();
      this.modalService.dismissAll();
    },
    err => {
    }
  );
}
public guardarproveedor() {
  (this.edit ? this.updateproveedor() : this.saveproveedor());
}

}
