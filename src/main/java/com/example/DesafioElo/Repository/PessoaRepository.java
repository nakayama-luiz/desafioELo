package com.example.DesafioElo.Repository;

import com.example.DesafioElo.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Pessoa findByCpf(String Cpf);




//    List<Pessoa> findAllByNome(String nome);

//    List<Pessoa> findByCpf(String Cpf);

//    Integer countAll();


}
