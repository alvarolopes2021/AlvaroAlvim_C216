package br.inatel.labs.lab_rest_server.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.inatel.labs.lab_rest_server.model.Curso;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CursoControllerTest {
	
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void deveListarCursos() {
		webTestClient.get()
		.uri("/curso/listar")
		.exchange()
		.expectStatus().isOk()
		.expectBody().returnResult(); //retornou alguma coisa
	}
	
	@Test
	void dadoCursoIdValido_quandoGetCursoPorId_entaoRespondeComCursoValido() {
		Long cursoIdValido = 1L;
		
		Curso response = webTestClient.get()
		.uri("/curso/search/" + cursoIdValido)
		.exchange()
		.expectStatus().isOk()
		.expectBody(Curso.class)
			.returnResult()
			.getResponseBody(); //retornou alguma coisa
		
		assertNotNull(response);
		
		assertEquals(response.getId(), cursoIdValido);	
		
	}
	
	@Test
	void dadoCursoIdInvalido_quandoGetCursoPorId_entaoRespondeComStatusNotFound() {
		Long cursoIdValido = 99L;
		
		webTestClient.get()
		.uri("/curso/search/" + cursoIdValido)
		.exchange()
		.expectStatus().isNotFound();
		
	}
	
	@Test
	void dadoNovoCurso_quandoPostCurso_entaoRespondeComStatusCreatedECursoValido() {
		Curso curso = new Curso(4L,"Testando REST com Spring WebFlux", 120 );
		
		Curso cursoResponse = webTestClient.post()
		.uri("/curso/create")
		.bodyValue(curso)
		.exchange()
		.expectStatus().isCreated()
		.expectBody(Curso.class).returnResult().getResponseBody();
		
		assertNotNull(cursoResponse);
		
	}

}
