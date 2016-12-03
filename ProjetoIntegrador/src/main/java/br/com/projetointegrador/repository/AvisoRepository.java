package br.com.projetointegrador.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projetointegrador.entity.Aviso;

public interface AvisoRepository extends CrudRepository<Aviso, Integer>{
	
	public List<Aviso> findByDestinatario(String destinatario);

}
