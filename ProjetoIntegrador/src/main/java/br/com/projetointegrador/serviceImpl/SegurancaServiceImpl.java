package br.com.projetointegrador.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.projetointegrador.entity.Usuario;
import br.com.projetointegrador.repository.UsuarioRepository;
import lombok.Data;

@Data
@Service("segurancaService")
public class SegurancaServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findUsuarioByLogin(userName);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		return usuario;
	}

}
