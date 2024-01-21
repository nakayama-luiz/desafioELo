package com.example.DesafioElo.Repository;

import com.example.DesafioElo.Model.Pessoa;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Pessoa findByCpf(String Cpf);

    List<Pessoa> findByCpfAndAndNome(String Cpf, String nome, Pageable page);



//    List<Pessoa> findAllByNome(String nome);

//    List<Pessoa> findByCpf(String Cpf);

//    Integer countAll();


}
