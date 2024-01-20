package com.example.DesafioElo.Service;

import com.example.DesafioElo.Model.Pessoa;
import com.example.DesafioElo.Repository.EnderecoRepository;
import com.example.DesafioElo.Repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {


    private PessoaRepository pessoaRepository;
    private EnderecoRepository enderecoRepository;

    public PessoaService(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoRepository = enderecoRepository;
    }


    public void createPerson(Pessoa pessoa){
        try{
            pessoaRepository.save(pessoa);

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void erradicarPessoa(Pessoa pessoa){
        try{
            pessoaRepository.delete(pessoa);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Optional<Pessoa> getPessoaById(Integer id){

        return pessoaRepository.findById(id);

    }



}
