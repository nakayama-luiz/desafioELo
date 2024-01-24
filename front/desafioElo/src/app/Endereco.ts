import {Pessoa} from "./Pessoa";

export interface Endereco{
  logradouro: string;
  cidade: string;
  numero: string;
  cep: number;
  uf: string;
  pessoa: Pessoa;

}
