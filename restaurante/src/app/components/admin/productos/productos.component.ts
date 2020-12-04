import { ProductoService } from './../../../services/producto.service';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Producto } from 'src/app/models/Producto';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {

  closeResult: string;
  @ViewChild('productoModal', {static: false}) modal: ElementRef;

  edit = false;
  producto: Producto = {
    id_producto: '',
    precio_product: 0,
    id_local: 0,
    nom_prod: '',
  };
  productos: any;
  constructor(private modalService: NgbModal, private productoService: ProductoService) { }

  ngOnInit(): void {
    this.getProductos();
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
getProductos() {
  this.productoService.getProductos().subscribe(
    (res: any) => {
      this.productos = res;
    },
    err => {

    }
  );
}

public editProducto(producto: Producto) {
  this.producto.nom_prod= producto.nom_prod;
  this.producto.precio_product = producto.precio_product;
  this.producto.id_local= producto.id_local;
  this.edit = true;
  this.modalService.open(this.modal);
}

public borrarProducto(id_producto: String) {
  this.productoService.deleteProducto(id_producto).subscribe(
    (res: any) => {
        this.getProductos();
    },
    err => {
    }
  );
}

public saveProducto() {
  this.productoService.guardarProducto(this.producto).subscribe(
    (res: any) => {
      this.getProductos();
    },
    err => {
    }
  );
}

public updateProducto() {
  this.productoService.updateProducto(this.producto.id_producto, this.producto).subscribe(
    (res: any) => {
      this.getProductos();
    },
    err => {

    }
  );
}
public guardarProducto() {
  (this.edit ? this.updateProducto() : this.saveProducto());
}

}
