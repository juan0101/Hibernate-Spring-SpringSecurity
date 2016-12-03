package br.com.projetointegrador.service;

import java.util.List;

import br.com.projetointegrador.entity.Usuario;

public interface UsuarioService {
	
	public void salvar(Usuario usuario);
	
	public void excluir(Integer idUsuario);
	
	public List<Usuario> listarTodosUsuarios();
	
	public Usuario buscarUsuarioNome(String nome);
	
	public Usuario buscarPorId(Integer idUsuario);
	
	public List<Usuario> buscarTodosByTipoUsuario(String tipoUsuario);
	
	public void salvarVinculoUsuarioPermissao(int idUsuario, int idPermissao);
	
	public void updateUsuario(Usuario usuario);

}
