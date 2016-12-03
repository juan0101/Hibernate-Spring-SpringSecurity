package br.com.projetointegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.projetointegrador.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

	public Usuario findByNome(String nome);
	
	public Usuario findTop1ByNomeContains(String nome);
	
	public List<Usuario> findByIdGreaterThan(int id);
	
	public Usuario findUsuarioByLoginAndSenha(String login, String senha);
	
	public Usuario findUsuarioByLogin(String login);
	
	public List<Usuario> findByTipoUsuario(String tipoUsuario);
	
	@Query("select u from Usuario u where u.tipoUsuario like %?1%")
	public List<Usuario> buscarTodosByTipoUsuario(String tipoUsuario);
	
}
