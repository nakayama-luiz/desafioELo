package com.example.DesafioElo.Service;

import com.example.DesafioElo.Model.Pessoa;
import com.example.DesafioElo.Repository.EnderecoRepository;
import com.example.DesafioElo.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {


    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoRepository = enderecoRepository;
    }


    public void createPerson(Pessoa pessoa){
        try{
            System.out.println(pessoa.getDataDeNascimento());
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
//    public List<Pessoa> getPessoaByName(String nome){
//        return pessoaRepository.findAllByNome(nome);
//    }
    public Pessoa getPessoaByCpf(String cpf){
        return pessoaRepository.findByCpf(cpf);
    }

    public long getPessoasCount(){
        return pessoaRepository.count();
    }


    public void atualizaPessoa(Integer id, Pessoa pessoa){
        Pessoa pessoaAtualizada = pessoaRepository.findById(id).get();

        pessoaAtualizada.setTelefone(pessoa.getTelefone());
        pessoaAtualizada.setNome(pessoa.getNome());
        pessoaAtualizada.setCpf(pessoa.getCpf());
        pessoaAtualizada.setDataDeNascimento(pessoa.getDataDeNascimento());
        pessoaAtualizada.setEndereco(pessoa.getEndereco());

        pessoaRepository.save(pessoaAtualizada);
    }



}
