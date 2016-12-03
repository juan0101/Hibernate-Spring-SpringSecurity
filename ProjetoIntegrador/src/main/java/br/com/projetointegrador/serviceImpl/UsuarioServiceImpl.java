package br.com.projetointegrador.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetointegrador.entity.Usuario;
import br.com.projetointegrador.repository.UsuarioRepository;
import br.com.projetointegrador.service.UsuarioService;
import lombok.Data;

@Service("usuarioService")
@Transactional
@Data
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepo;

	@Override
	public void salvar(Usuario usuario) {
		try{
			System.out.println("Salvando usuario");
			usuarioRepo.save(usuario);
			System.out.println("Usuario Salvo");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Integer idUsuario) {
		try{
			System.out.println("Deletando usuario");
			usuarioRepo.delete(idUsuario);
			System.out.println("Usuario deletado");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Usuario> listarTodosUsuarios() {
		try{
			List<Usuario> usuarios = new ArrayList<Usuario>();
			for(Usuario usu: usuarioRepo.findAll()){
				System.out.println(usu.getNome());
				usuarios.add(usu);
			}
			return usuarios;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario buscarUsuarioNome(String nome) {
		try{
			Usuario usuario = null;
			System.out.println("Buscando usuario");
			usuario = usuarioRepo.findByNome(nome);
			if(usuario != null){
				return usuario;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		try{
			Usuario usuario = null;
			System.out.println("Buscando usuario");
			usuario = usuarioRepo.findOne(idUsuario);
			if(usuario != null){
				return usuario;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Usuario> buscarTodosByTipoUsuario(String tipoUsuario) {
		try{
			List<Usuario> usuarios = new ArrayList<Usuario>();
			System.out.println("BUSCANDO USUARIOS");
			for(Usuario usu: usuarioRepo.findByTipoUsuario(tipoUsuario)){
				System.out.println(usu.getNome());
				usuarios.add(usu);
			}
			if(!usuarios.isEmpty()){
				return usuarios;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void salvarVinculoUsuarioPermissao(int idUsuario, int idPermissao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		try{
			System.out.println("Salvando usuario");
			usuarioRepo.save(usuario);
			System.out.println("Usuario Salvo");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
