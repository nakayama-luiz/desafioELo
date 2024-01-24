import {Component, Input, Output} from '@angular/core';
import {OnInit} from "@angular/core";
import {PessoaService} from "../../pessoa.service";
import {VIACEP} from "../../VIACEP";
import {Pessoa} from "../../Pessoa";
import {Endereco} from "../../Endereco";
import {ConsoleLogger} from "@angular/compiler-cli";

@Component({
  selector: 'app-cadastro-unico',
  templateUrl: './cadastro-unico.component.html',
  styleUrl: './cadastro-unico.component.css'
})
export class CadastroUnicoComponent implements OnInit{



  ngOnInit(): void {

    // throw new Error('Method not implemented.');
  }
  @Input() uf: string='';
  @Input() logradouro: string='';
  @Input() cidade: string ='';
  CEP: string='';

  nome:string='';
  cpf: string='';
  telefone: string='';
  dataDeNascimento: string='';




  constructor(private PessoaService: PessoaService) {
  }

  adress: VIACEP={
    cep: 'string',
    logradouro: 'string',
    complemento: 'string',
    bairro: 'string',
    localidade: 'string',
    uf: 'string',
    ibge: 'string',
    gia: 'string',
    ddd: 'string',
    siafi: 'string'
  }
  enderecos: Endereco[] = [

  ]



  pessoa: Pessoa ={
    nome: '',
    cpf: '',
    telefone: '',
    dataDeNascimento: '',
    endereco: this.enderecos,
    id:0
  };

  endereco: Endereco={
    logradouro: '',
    cidade: '',
    numero: '',
    cep: 0,
    uf: '',
    pessoa: this.pessoa
  }


  pessoaTEste: Pessoa ={
    nome: '',
    cpf: '',
    telefone: '',
    dataDeNascimento: '',
    endereco: this.enderecos,
    id:0
  };
  identificador!: number;

  compras: any

  async esperarPorTempo(ms: number): Promise<void> {
    return new Promise(resolve => {
      setTimeout(() => {
        resolve();
      }, ms);
    });
  }

  async CreatePessoa(): Promise<void> {


    await this.PessoaService.CreatePeople(this.pessoa).then(async value=>{
      value.subscribe(value1 => console.log(value1))
    })
      await this.esperarPorTempo(5000);

     await this.PessoaService.FindByCPf(this.pessoa.cpf).then(async value => {
      value.subscribe(value1 => this.endereco.pessoa.id = value1.id)

    });
    await this.esperarPorTempo(5000);
    if(this.endereco.pessoa.id==null){
        await this.PessoaService.FindByCPf(this.pessoa.cpf).then(async value => {
            value.subscribe(value1 => this.endereco.pessoa.id = value1.id)

        });
    }
    console.log(this.endereco.pessoa.id)

    this.PessoaService.CreateAdress(this.endereco).subscribe(value => console.log(value))


  }


  onChangeCEP(): void{
    console.log(this.PessoaService.DynamicAdressCreator(this.endereco.cep.toString()).subscribe((value) =>{
        // this.cidade = value.localidade;
        // this.logradouro = value.logradouro;
        // this.uf = value.uf;
        this.endereco.cidade = value.localidade;
        this.endereco.logradouro = value.logradouro;
        this.endereco.uf = value.uf;
    }



    ));
    // console.log(this.adress.localidade)
    // // this.logradouro = this.CEP;
    // // this.cidade= this.adress.localidade;
    // this.logradouro = this.adress.logradouro;
    // this.uf = this.adress.uf;

  }

}
