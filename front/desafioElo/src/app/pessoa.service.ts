import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {VIACEP} from "./VIACEP";
import {Pessoa} from "./Pessoa";
import {Endereco} from "./Endereco";

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  constructor(private cliente: HttpClient) {

  }

  api:string = 'http://18.117.131.132:8081/countPeople'
  apiReal:string = 'http://18.117.131.132:8081/'

  apiviacep:string = 'https://viacep.com.br/ws/';

  trasiotrio: any ={
    "cep": 87060420,
    "cidade": "Maringá",
    "logradouro": "Jardim Universo",
    "numero": "246",
    "uf": "PR",
    "pessoa": {
      "nome": "Pedro Medeiros",
      "cpf": "46478832058",
      "telefone": "4647883-2058",
      "endereco": [],
      "dataDeNascimento": '2023-03-09',
      id: 0
    }
  }

  DynamicAdressCreator(cep: string): Observable<any>{

    return this.cliente.get<any>(this.apiviacep+'/'+cep+'/json');
  }

  async CreatePeople(pessoa: Pessoa): Promise<Observable<any>>{
    console.log('montando')
    return this.cliente.post(`${this.apiReal}addPessoa`, pessoa);
  }

  async FindByCPf(cpf: string): Promise<Observable<any>>{
    return this.cliente.get<any>('http://18.117.131.132:8081/'+'getPessoaByCpf/'+cpf);
  }



  CreateAdress(adress: Endereco): Observable<any>{
    console.log(adress.pessoa)
    // this.trasiotrio = adress;
    this.trasiotrio.pessoa.id=adress.pessoa.id;
    this.trasiotrio.cep=adress.cep;
    this.trasiotrio.cidade=adress.cidade;
    this.trasiotrio.uf=adress.uf;
    this.trasiotrio.logradouro=adress.logradouro;

    return this.cliente.post(`${this.apiReal}createAdress`, this.trasiotrio)
  }
 PeopleCount(): Observable<any>{

    return this.cliente.get<any>(this.api);

  }
 PessoaFilterCpforName(nome: string, cpf:string): Observable<any>{
    return this.cliente.get<any>('http://18.117.131.132:8081/PesquisarPessoasEmPaginas?Nome='+nome+'&cCf='+cpf);
 }



}
