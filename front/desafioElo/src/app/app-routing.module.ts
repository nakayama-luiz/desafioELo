import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {applyMixins} from "rxjs/internal/util/applyMixins";
import {HomeComponent} from "./componentes/home/home.component";
import {CadastroUnicoComponent} from "./componentes/cadastro-unico/cadastro-unico.component";
import {PesquisaComponent} from "./componentes/pesquisa/pesquisa.component";


const routes: Routes = [
  {path: '', component: HomeComponent },
  {path: 'commounCreate', component: CadastroUnicoComponent},
  {path:'pesquisa', component: PesquisaComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: []
})
export class AppRoutingModule { }
