package com.example.DesafioElo;

import com.example.DesafioElo.Model.Pessoa;
import com.example.DesafioElo.Model.Validador;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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
		Validador validador = new Validador();

		String cpf = "08861472982";

		Assertions.assertTrue(validador.cpfValidado(cpf));
	}


	@Test //valida falso
	void TesteCpfValidatorFalso(){
		Validador validador = new Validador();

		String cpf = "099614729";

		Assertions.assertFalse(validador.cpfValidado(cpf));
	}


	@Test
	void ValidarQuantidadeDeCaracteresDoTelefoneVerdadeiro(){
		Validador validador = new Validador();
		String telefone =  "44998435720";
		Assertions.assertTrue(validador.TelefoneLimit(telefone));
	}


	@Test
	void ValidarData(){
		Validador validador = new Validador();
		LocalDate.parse("2025-06-02");
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.format(date);

//			date=dateFormat.parse("2025-06-02");

			Assertions.assertFalse(validador.ValidaData(LocalDate.parse("2025-06-02")));

	}

}
