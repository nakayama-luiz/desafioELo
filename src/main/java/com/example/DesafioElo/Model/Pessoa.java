package com.example.DesafioElo.Model;


import br.com.caelum.stella.validation.CPFValidator;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pessoa")
public class Pessoa {



    @Id
    @Column(name = "Id_pessoa",nullable = false,unique = true)
    @SequenceGenerator(name = "seq_pessoa")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "DataDeNascimento", nullable = false)
    private LocalDate DataDeNascimento;

    @Column(name = "cpf", nullable = false, unique = true, precision = 11)
    private String cpf;

    @Column(name = "telefone", nullable = false, precision = 11)
    private String telefone;


    @OneToMany(mappedBy = "pessoa")
    //@JoinColumn(name = "Idereco", nullable = false)
    private List<Endereco> endereco;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

//    public Date getDataDeNascimento() {
//        return DataDeNascimento;
//    }
//
//    public void setDataDeNascimento(Date dataDeNascimento) {
//        DataDeNascimento = dataDeNascimento;
//    }


    public LocalDate getDataDeNascimento() {
        return DataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        DataDeNascimento = dataDeNascimento;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
}
