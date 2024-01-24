import {Endereco} from "./Endereco";


export interface Pessoa{
  nome: string;
  cpf: string;
  telefone: string;
  dataDeNascimento: string;
  endereco: Endereco[];
  id: number


}
