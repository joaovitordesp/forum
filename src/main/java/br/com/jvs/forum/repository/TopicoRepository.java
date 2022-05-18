package br.com.jvs.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jvs.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao); //curso é a entidade e Nome é o atributo dessa clase
	
//	@Query("SELECT t FROM Topico t WHERE t.curso.nome =:nomeCurso")
//	List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);

}
