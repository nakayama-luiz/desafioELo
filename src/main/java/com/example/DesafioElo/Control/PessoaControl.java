package com.example.DesafioElo.Control;

import com.example.DesafioElo.Model.Endereco;
import com.example.DesafioElo.Model.Pessoa;
import com.example.DesafioElo.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaControl {
    private final PessoaService pessoaService;

    @Autowired
    public PessoaControl(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/compras")
    public long countAllById(){
        return pessoaService.getPessoasCount();
    }

    @GetMapping("/getPessoaByCpf/{cpf}")
    public Pessoa getPessoasByName(@PathVariable String cpf){
        return pessoaService.getPessoaByCpf(cpf);
    }

    @PostMapping("/addPessoa")
    public void addPessoa(@RequestBody Pessoa pessoa){
        System.out.println(pessoa.getDataDeNascimento());
        pessoaService.createPerson(pessoa);
    }

    @DeleteMapping("/removePessoa")
    public void removePessoa(@RequestBody Pessoa pessoa){
        pessoaService.erradicarPessoa(pessoa);
    }

    @PutMapping("updatePessoa/{id}")
    public void updatePessoa(@PathVariable Integer id, @RequestBody Pessoa pessoa){
        pessoaService.atualizaPessoa(id, pessoa);
    }
}
