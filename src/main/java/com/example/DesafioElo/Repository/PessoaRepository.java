package com.example.DesafioElo.Repository;

import com.example.DesafioElo.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    List<Pessoa> pessoasPorNome(String nome);

    List<Pessoa> pessoaPelo(String cpf);


}
