package com.example.DesafioElo.Model;

import br.com.caelum.stella.validation.CPFValidator;
import jakarta.persistence.*;

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
    private String Nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "DataDeNascimento", nullable = false)
    private Date DataDeNascimento;

    @Column(name = "Cpf", nullable = false, unique = true, precision = 11)
    private String Cpf;

    @Column(name = "Telefone", nullable = false)
    private String Telefone;


    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "Idereco", nullable = false)
    private List<Endereco> endereco;

    public boolean cpfValidado(String cpf){
        CPFValidator cpfValidator = new CPFValidator();
        try{
            cpfValidator.assertValid(cpf);
            return  true;
        }catch (Exception error){
            return false;

        }
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Date getDataDeNascimento() {
        return DataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        DataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
}
