package com.example.DesafioElo;

import com.example.DesafioElo.Control.PessoaControl;
import com.example.DesafioElo.Model.Pessoa;
import com.example.DesafioElo.Model.Vaildador;
import com.example.DesafioElo.Service.PessoaService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesafioEloApplicationTests {

	@Autowired
	EntityManager entityManager;

	@Test
	void contextLoads() {
	}

	@Test
	void testeUpdate(){
		Pessoa pessoa = new Pessoa();


		Assertions.assertNotEquals(pessoa, pessoa);

	}


	@Test //valida correto
	void TesteCpfValidatorCorreto(){
		Vaildador vaildador = new Vaildador();

		String cpf = "08861472982";

		Assertions.assertTrue(vaildador.cpfValidado(cpf));
	}


	@Test //valida correto
	void TesteCpfValidatorFalso(){
		Vaildador vaildador = new Vaildador();

		String cpf = "099614729";

		Assertions.assertFalse(vaildador.cpfValidado(cpf));
	}




}
