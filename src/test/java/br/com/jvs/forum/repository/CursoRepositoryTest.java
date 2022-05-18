package br.com.jvs.forum.repository;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.jvs.forum.modelo.Curso;

@DataJpaTest
class CursoRepositoryTest {
	@Autowired
	private CursoRepository cursoRepository;
	
	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		String nomeCurso = "HTML 5";
		Curso curso = cursoRepository.findByNome(nomeCurso);
		System.out.println(curso);
	}

}
