package org.generation.BlogPessoal.model;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UsuarioLoginTest {
	
	private UsuarioLogin login1;
	private @Autowired ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	@BeforeEach
	public void start() {		
		 login1 = new UsuarioLogin("", "Otavio", "12345", "QnJ1bmEgQmVyZ2FtaToxMjM0NTY3");
	}
	
	@Test
	void testUsuarioNameBlankReturnException() {
		Set<ConstraintViolation<UsuarioLogin>> validation = validator.validate(login1);
		
		assertFalse(validation.isEmpty());
	}
}
