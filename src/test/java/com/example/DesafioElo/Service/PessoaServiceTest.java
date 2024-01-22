package com.example.DesafioElo.Service;

import com.example.DesafioElo.Model.Endereco;
import com.example.DesafioElo.Model.Pessoa;
import com.example.DesafioElo.Model.Validador;
import com.example.DesafioElo.Repository.EnderecoRepository;
import com.example.DesafioElo.Repository.PessoaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private EnderecoRepository enderecoRepository;

    @Mock
    private PessoaService pessoaService;

    @Mock
    private EnderecoService enderecoService;

    @Mock
    private Validador validador;

    @BeforeEach
    void configurar(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("Deve criar uma nova Pessoa")
    void createPerson() {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("carlos");
        pessoa.setId(1);
        pessoa.setCpf("08861472982");
        pessoa.setTelefone("44998435720");
        pessoa.setDataDeNascimento(LocalDate.parse("2003-03-30"));


        when(validador.cpfValidado(pessoa.getCpf())).thenReturn(true);
        when(validador.ValidaData(pessoa.getDataDeNascimento())).thenReturn(true);
        when(validador.TelefoneLimit(pessoa.getTelefone())).thenReturn(true);

        pessoaService.createPerson(pessoa);

        verify(pessoaService, times(1)).createPerson(pessoa);

    }

    @Test
    @DisplayName("Deve falhar em criar uma nova Pessoa, devido ao CPF")
    void createPersonFailDueCpf() {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("carlos");
        pessoa.setId(1);
        pessoa.setCpf("11111111111");
        pessoa.setTelefone("44998435720");
        pessoa.setDataDeNascimento(LocalDate.parse("2003-03-30"));

        when(validador.cpfValidado(pessoa.getCpf())).thenReturn(false);

        pessoaService.createPerson(pessoa);

       verify(pessoaRepository, times(0)).save(pessoa);

    }
}