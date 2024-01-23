package com.example.DesafioElo.Service;

import com.example.DesafioElo.Model.Endereco;
import com.example.DesafioElo.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public void addAdress(Endereco endereco){
        enderecoRepository.save(endereco);
    }

    public long findAlladreses(){
        return enderecoRepository.count();
    }

}
