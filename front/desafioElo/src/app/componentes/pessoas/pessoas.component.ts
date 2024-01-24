import { Component } from '@angular/core';
import {OnInit} from "@angular/core";
import {PessoaService} from "../../pessoa.service";
import {Observable} from "rxjs";
import {NgModule} from "@angular/core";
import {HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-pessoas',
  templateUrl: './pessoas.component.html',
  styleUrl: './pessoas.component.css'
})

// @NgModule({
//   imports: [HttpClientModule],
//   exports: [HttpClientModule]
// })
export class PessoasComponent implements OnInit{
  constructor(private PessoaService: PessoaService) {
  }
  total: any =0;
  totalPessoas: number =0;
  ngOnInit() {
    // throw new Error('Para todos os efeitos.');
    this.PessoaService.PeopleCount().subscribe(value => this.total=value);

  }







}
