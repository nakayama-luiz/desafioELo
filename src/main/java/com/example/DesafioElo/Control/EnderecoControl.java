package com.example.DesafioElo.Control;

import com.example.DesafioElo.Model.Endereco;
import com.example.DesafioElo.Repository.EnderecoRepository;
import com.example.DesafioElo.Service.EnderecoService;
import org.hibernate.collection.spi.PersistentSortedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EnderecoControl {
    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoControl(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }


    @PostMapping("/createAdress")
    public void creatreEndereco(@RequestBody Endereco endereco){
        enderecoService.addAdress(endereco);
    }

    @GetMapping("/countAllAdresses")
    public Long listAllAdresses(){
        return  enderecoService.findAlladreses();
    }



}
