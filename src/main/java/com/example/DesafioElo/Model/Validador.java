package com.example.DesafioElo.Model;

import br.com.caelum.stella.validation.CPFValidator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Validador {

    public boolean cpfValidado(String cpf){
        CPFValidator cpfValidator = new CPFValidator();
        try{
            cpfValidator.assertValid(cpf);
            return  true;
        }catch (Exception error){
            return false;
        }
    }

    public boolean TelefoneLimit(String telefone){
        if(telefone.length()!=11){
            return false;
        }else{
            return true;
        }
    }

    public boolean ValidaData(LocalDate data){
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//
//        dateFormat.format(date);
//        System.out.println(date);
//
//        if(data.before(date)){
//            return true;
//        }else {
//            return false;
//        }
        LocalDate dataAtual = LocalDate.now();
        // Comparando as datas
        return data.isBefore(dataAtual);
    }

}
