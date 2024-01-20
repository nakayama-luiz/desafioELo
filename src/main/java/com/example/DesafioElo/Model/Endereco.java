package com.example.DesafioElo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @SequenceGenerator(name = "seq_endereco")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Idereco")
    private Integer Id;

    @Column(name = "cep")
    private Integer Cep;

    @Column(name = "UF", length = 2)
    private String UF;

    @ManyToOne
    @JoinColumn(name = "Id_pessoa", nullable = true)
    private Pessoa pessoa;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "cidade",  nullable = false)
    private String cidade;

    @Column(name = "numero", nullable = false)
    private String numero; //casa A e B

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getCep() {
        return Cep;
    }

    public void setCep(Integer cep) {
        Cep = cep;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
