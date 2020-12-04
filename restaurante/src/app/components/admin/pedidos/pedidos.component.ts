import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Pedidos } from 'src/app/models/Pedidos';
import { PedidosService } from 'src/app/services/pedidos.service';

@Component({
  selector: 'app-pedidos',
  templateUrl: './pedidos.component.html',
  styleUrls: ['./pedidos.component.css']
})
export class PedidosComponent implements OnInit {

  closeResult: string;
  @ViewChild('pedidoModal', {static: false}) modal: ElementRef;

  edit = false;
  pedido: Pedidos = {
    id_pedido: 0,
    tipo_pedido: '',
  };
  pedidos: any;
  constructor(private modalService: NgbModal, private pedidosService: PedidosService) { }


  ngOnInit(): void {
    this.getPedidos();
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
getPedidos() {
  this.pedidosService.getPedidos().subscribe(
    (res: any) => {
      this.pedidos = res;
    },
    err => {

    }
  );
}

public editPedidos(pedidos: Pedidos) {
  this.pedidos.tipo_pedido= pedidos.tipo_pedido;
  this.edit = true;
  this.modalService.open(this.modal);
}

public borrarPedidos(id_pedido: number) {
  this.pedidosService.deletePedidos(id_pedido).subscribe(
    (res: any) => {
        this.getPedidos();
    },
    err => {
    }
  );
}

public savePedidos() {
  this.pedidosService.guardarPedidos(this.pedidos).subscribe(
    (res: any) => {
      this.getPedidos();
    },
    err => {
    }
  );
}

public updatePedidos() {
  this.pedidosService.updatePedidos(this.pedidos.id_pedido, this.pedidos).subscribe(
    (res: any) => {
      this.getPedidos();
    },
    err => {

    }
  );
}
public guardarPedidos() {
  (this.edit ? this.updatePedidos : this.savePedidos());
}

}
