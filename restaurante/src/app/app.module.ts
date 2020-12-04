import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/layout/navbar/navbar.component';
import { SectionAboutComponent } from './components/layout/section-about/section-about.component';
import { SectionMenuComponent } from './components/layout/section-menu/section-menu.component';
import { SectionGalleryComponent } from './components/layout/section-gallery/section-gallery.component';
import { SectionContactComponent } from './components/layout/section-contact/section-contact.component';
import { FooterComponent } from './components/layout/footer/footer.component';
import { Route, RouterModule } from '@angular/router';
import { LayoutAdminComponent } from './components/admin/layout-admin/layout-admin.component';
import { PrincipalAdminComponent } from './components/admin/principal-admin/principal-admin.component';
import { PrincipalLayoutComponent } from './components/layout/principal-layout/principal-layout.component';
import { BarraNotifComponent } from './components/admin/layout/barra-notif/barra-notif.component';
import { MenuAdminComponent } from './components/admin/layout/menu-admin/menu-admin.component';
import { ClienteComponent } from './components/admin/cliente/cliente.component';
import { EmpleadoComponent } from './components/admin/empleado/empleado.component';
import { ProveedoresComponent } from './components/admin/proveedores/proveedores.component';
import { UsuariosComponent } from './components/admin/usuarios/usuarios.component';
import { ProductosComponent } from './components/admin/productos/productos.component';
import { LocalesComponent } from './components/admin/locales/locales.component';
import { CargosComponent } from './components/admin/cargos/cargos.component';
import { TelefonoComponent } from './components/admin/telefono/telefono.component';
import { PedidosComponent } from './components/admin/pedidos/pedidos.component';
import { MenuComponent } from './components/admin/menu/menu.component';
import { PlatosComponent } from './components/admin/platos/platos.component';
import { IngredientesComponent } from './components/admin/ingredientes/ingredientes.component';
import { TipoPlatoComponent } from './components/admin/tipo-plato/tipo-plato.component';

const routes: Route[] = [
  {path: '', component: PrincipalLayoutComponent},
  {
    path: 'admin', component: LayoutAdminComponent,
    children: [{ path: '', component: PrincipalAdminComponent },
    { path: 'cliente', component: ClienteComponent },
    { path: 'proveedores', component: ProveedoresComponent },
    { path: 'productos', component: ProductosComponent },
    { path: 'locales', component: LocalesComponent },
    { path: 'cargos', component: CargosComponent },
    { path: 'usuarios', component: UsuariosComponent },
    { path: 'empleados', component: EmpleadoComponent },
    { path: 'pedidos', component: PedidosComponent },
    { path: 'telefonos', component: TelefonoComponent },
    { path: 'platos', component: PlatosComponent },
    { path: 'tipoPlato', component: TipoPlatoComponent },
    { path: 'menu', component: MenuComponent },
    { path: 'ingredientes', component: IngredientesComponent }]
  }
];
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SectionAboutComponent,
    SectionMenuComponent,
    SectionGalleryComponent,
    SectionContactComponent,
    FooterComponent,
    LayoutAdminComponent,
    PrincipalAdminComponent,
    PrincipalLayoutComponent,
    BarraNotifComponent,
    MenuAdminComponent,
    ClienteComponent,
    EmpleadoComponent,
    ProveedoresComponent,
    UsuariosComponent,
    ProductosComponent,
    LocalesComponent,
    CargosComponent,
    TelefonoComponent,
    PedidosComponent,
    MenuComponent,
    PlatosComponent,
    IngredientesComponent,
    TipoPlatoComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
