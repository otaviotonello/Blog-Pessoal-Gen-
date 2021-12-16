package org.generation.BlogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.generation.BlogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	private @Autowired UsuarioRepository repository;
	
	@BeforeAll
	void start() {
		repository.save(new Usuario("Alan", "alanminecraft", "134652"));
		repository.save(new Usuario("Murilo", "murilocouto", "134652"));
		repository.save(new Usuario("Gustavo", "gugugalo", "134652"));
		repository.save(new Usuario("Joel", "joelirmao", "134652"));
		repository.save(new Usuario("Otavio", "tavinben10", "134652"));
	}
	
	@Test
	@DisplayName("Search valid usuario!")
	void searchUsuarioValidReturnObjectValid() {
		
		//When
		Usuario user = repository.findByUsuario("murilocouto").get();
		
		//Then
		assertTrue(user.getNome().equals("Murilo"));
	}
	
	@Test
	@DisplayName("Search invalid Name!")
	void searchNameInvalidReturnOptionalEmpty() {
		
		//When
		Optional<Usuario> optional = repository.findByNome("");
		
		//Then
		assertTrue(optional.isEmpty());
	}
}
