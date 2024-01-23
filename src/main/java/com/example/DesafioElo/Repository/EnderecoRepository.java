package com.example.DesafioElo.Repository;

import com.example.DesafioElo.Model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
