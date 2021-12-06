package org.generation.BlogPessoal.repository;

import java.util.List;

import org.generation.BlogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface temaRepository extends JpaRepository<Tema, Long> {

	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
	
}
