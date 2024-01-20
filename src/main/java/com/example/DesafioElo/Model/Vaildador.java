package com.example.DesafioElo.Model;

import br.com.caelum.stella.validation.CPFValidator;

public class Vaildador {

    public boolean cpfValidado(String cpf){
        CPFValidator cpfValidator = new CPFValidator();
        try{
            cpfValidator.assertValid(cpf);
            return  true;
        }catch (Exception error){
            return false;
        }
    }
}
