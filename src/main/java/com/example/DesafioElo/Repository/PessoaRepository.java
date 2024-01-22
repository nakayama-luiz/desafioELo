package com.example.DesafioElo.Repository;

import com.example.DesafioElo.Model.Pessoa;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Pessoa findByCpf(String Cpf);

    List<Pessoa> findByCpfAndAndNome(String Cpf, String nome, Pageable page);

    List<Pessoa> findAllByCpfOrNome(String Cpf, String nome, Pageable pageable);

    List<Pessoa> findAllByCpfLikeOrNomeLike(String Cpf, String nome, Pageable pageable);

    List<Pessoa> findAllByCpfContainingOrNomeContainingIgnoreCase(String Cpf, String nome, Pageable pageable);
//    List<Pessoa> findAllByNome(String nome);

//    List<Pessoa> findByCpf(String Cpf);

//    Integer countAll();


}
