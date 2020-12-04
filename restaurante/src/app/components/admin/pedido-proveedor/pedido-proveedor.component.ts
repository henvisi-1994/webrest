import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PedidoProveedor } from 'src/app/models/PedidoProveedor';
import { Producto } from 'src/app/models/Producto';
import { PedidoProveedorService } from 'src/app/services/pedido-proveedor.service';

@Component({
  selector: 'app-pedido-proveedor',
  templateUrl: './pedido-proveedor.component.html',
  styleUrls: ['./pedido-proveedor.component.css']
})
export class PedidoProveedorComponent implements OnInit {

  closeResult: string;
  @ViewChild('pedidoproveedorModal', {static: false}) modal: ElementRef;

  edit = false;
  pedidoproveedor: PedidoProveedor = {
    id_dedido_prov: 0,
    cantidad_pedido_prov: 0,
    Fecha_caducidad_ped_prov: new Date(),
    id_prov: 0,
    id_local: 0,
  };
  pedidoproveedores: any;

  constructor(private modalService: NgbModal, private pedidoproveedorService: PedidoProveedorService) { }

  ngOnInit(): void {
    this.getPedidoProveedor();
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

getPedidoProveedor() {
  this.pedidoproveedorService.getPedidoProveedores().subscribe(
    (res: any) => {
      this.pedidoproveedores = res;
    },
    err => {

    }
  );
}

public editPedidoProveedor(pedidoproveedor: PedidoProveedor) {
  this.pedidoproveedor.cantidad_pedido_prov= pedidoproveedor.cantidad_pedido_prov;
  this.pedidoproveedor.Fecha_caducidad_ped_prov = pedidoproveedor.Fecha_caducidad_ped_prov;
  this.pedidoproveedor.id_prov = pedidoproveedor.id_prov;
  this.pedidoproveedor.id_local = pedidoproveedor.id_local;
  this.edit = true;
  this.modalService.open(this.modal);
}

public borrarPedidoProveedor(id_dedido_prov: number) {
  this.pedidoproveedorService.deletePedidoProveedor(id_dedido_prov).subscribe(
    (res: any) => {
        this.getPedidoProveedor();
    },
    err => {
    }
  );
}

public savePedidoProveedor() {
  this.pedidoproveedorService.guardarPedidoProveedor(this.pedidoproveedor).subscribe(
    (res: any) => {
      this.getPedidoProveedor();
    },
    err => {
    }
  );
}

public updatePedidoProveedor() {
  this.pedidoproveedorService.updatePedidoProveedor(this.pedidoproveedor.id_dedido_prov, this.pedidoproveedor).subscribe(
    (res: any) => {
      this.getPedidoProveedor();
    },
    err => {

    }
  );
}
public guardarPedidoProveedor() {
  (this.edit ? this.updatePedidoProveedor() : this.savePedidoProveedor());
}

}
