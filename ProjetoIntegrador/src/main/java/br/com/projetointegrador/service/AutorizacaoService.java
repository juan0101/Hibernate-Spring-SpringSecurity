package br.com.projetointegrador.service;

import java.util.List;

import br.com.projetointegrador.entity.Autorizacao;

public interface AutorizacaoService {
	
	public Autorizacao salvar(Autorizacao autorizacao);
	
	public void excluir(int idAutorizacao);
	
	public List<Autorizacao> todos();
	
	public List<Autorizacao> buscar(String nome);
	
	public Autorizacao buscarPorId(int idAutorizacao);

}
