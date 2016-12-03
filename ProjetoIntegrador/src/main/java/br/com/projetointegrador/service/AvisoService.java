package br.com.projetointegrador.service;

import java.util.List;

import br.com.projetointegrador.entity.Aviso;

public interface AvisoService {
	
	public List<Aviso> buscarAvisos(String remetente);
	
	public void salvar(Aviso aviso);

}
