package org.generation.BlogPessoal.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UsuarioLoginTest {
	
	private UsuarioLogin loginError;
	private UsuarioLogin loginNotError;
	private Validator validator;
	private @Autowired ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private Set<ConstraintViolation<UsuarioLogin>> validation;
	
	@BeforeEach
	public void start() {		
		validator = factory.getValidator();
	}
	
	@Test
	@DisplayName("Test Error name")
	void testUsuarioError(){
		
		//given
		loginError = new UsuarioLogin("", "otavio", "12345", "QnJ1bmEgQmVyZ2FtaToxMjM0NTY3");
		
		//when
		validation = validator.validate(loginError);
		
		//then
		assertFalse(validation.isEmpty());
	}
	
	@Test
	@DisplayName("Test NotError Ok")
	void testUsuarioNotError(){
		
		//given
		loginNotError = new UsuarioLogin("Otavio Tonello", "otaviotonello", "12345678", "QnJ1bmEgQmVyZ2FtaToxMjM0NTY3");
		
		//when
		validation = validator.validate(loginNotError);
		
		//then
		assertTrue(validation.isEmpty());
		
	}
}