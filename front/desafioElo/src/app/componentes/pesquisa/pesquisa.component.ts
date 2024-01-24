import { Component } from '@angular/core';
import {PessoaService} from "../../pessoa.service";
import {OnInit} from "@angular/core";

@Component({
  selector: 'app-pesquisa',
  templateUrl: './pesquisa.component.html',
  styleUrl: './pesquisa.component.css'
})
export class PesquisaComponent implements OnInit{

  ngOnInit() {
  }

  nome: string ='';
  cpf:string='';

  printName:string='';
  printCpf:string='';
  telefone:string='';

  datadenascimento:string='';

  listPessoa: any[] = [

  ]
  constructor(private PessoaService: PessoaService) {
  }

  pesquisaComFiltro(): any{
    this.PessoaService.PessoaFilterCpforName(this.nome, this.cpf).subscribe(value => {
      console.log(value)
      this.listPessoa=value;
    })
    console.log(this.listPessoa)

  }





}
