package br.com.projetointegrador.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projetointegrador.entity.Autorizacao;

public interface AutorizacaoRepository extends CrudRepository<Autorizacao, Integer> {

	public List<Autorizacao> findByNomeContainsIgnoreCase(String nome);
	
}
