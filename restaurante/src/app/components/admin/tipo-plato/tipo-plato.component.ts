import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-tipo-plato',
  templateUrl: './tipo-plato.component.html',
  styleUrls: ['./tipo-plato.component.css']
})
export class TipoPlatoComponent implements OnInit {

  closeResult: string;
  @ViewChild('tipPlatoModal', {static: false}) modal: ElementRef;
  constructor(private modalService: NgbModal) { }

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

}
