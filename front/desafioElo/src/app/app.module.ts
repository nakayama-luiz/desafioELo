import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {PessoaService} from "./pessoa.service";
import { NavBarComponent } from './componentes/nav-bar/nav-bar.component';
import { PessoasComponent } from './componentes/pessoas/pessoas.component';
import {HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './componentes/home/home.component';
import { CadastroUnicoComponent } from './componentes/cadastro-unico/cadastro-unico.component';
import {FormsModule} from "@angular/forms";
import {RouterOutlet} from "@angular/router";
import { PesquisaComponent } from './componentes/pesquisa/pesquisa.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    PessoasComponent,
    HomeComponent,
    CadastroUnicoComponent,
    PesquisaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterOutlet,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
