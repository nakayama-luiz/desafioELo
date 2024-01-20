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
    @JoinColumn(name = "Id_pessoa", nullable = false)
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
}
