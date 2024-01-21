package com.example.DesafioElo.Service;

import com.example.DesafioElo.Model.Pessoa;
import com.example.DesafioElo.Model.Validador;
import com.example.DesafioElo.Repository.EnderecoRepository;
import com.example.DesafioElo.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        Validador validador = new Validador();
        try{
            if(!(validador.cpfValidado(pessoa.getCpf()))){
                throw new Exception("CPF inválido.");
            }

            if(!(validador.ValidaData(pessoa.getDataDeNascimento()))){
                throw new Exception("A Data não pode ser posterior ao dia de hoje.");
            }


            if(!(validador.TelefoneLimit(pessoa.getTelefone()))){
                throw new Exception("O telefone deve ter 11 caracteres.");
            }

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
        try{
            Validador validador=new Validador();


            if(!(validador.cpfValidado(pessoa.getCpf()))){
                throw new Exception("CPF inválido.");
            }

            if(!(validador.ValidaData(pessoa.getDataDeNascimento()))){
                throw new Exception("A Data não pode ser posterior ao dia de hoje.");
            }


            if(!(validador.TelefoneLimit(pessoa.getTelefone()))){
                throw new Exception("O telefone deve ter 11 caracteres.");
            }

            Pessoa pessoaAtualizada = pessoaRepository.findById(id).get();

            pessoaAtualizada.setTelefone(pessoa.getTelefone());
            pessoaAtualizada.setNome(pessoa.getNome());
            pessoaAtualizada.setCpf(pessoa.getCpf());
            pessoaAtualizada.setDataDeNascimento(pessoa.getDataDeNascimento());
            pessoaAtualizada.setEndereco(pessoa.getEndereco());

            pessoaRepository.save(pessoaAtualizada);


        }catch (Exception e){
            System.out.println(e);
        }




    }

    public List<Pessoa> PesquisaPaginadaPessoa(String cpf, String nome){
        Pageable pageable = PageRequest.of(0, 2);

        return pessoaRepository.findByCpfAndAndNome(cpf, nome, pageable);

    }



}
