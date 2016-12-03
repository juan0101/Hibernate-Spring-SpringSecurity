package br.com.projetointegrador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.projetointegrador.entity.Autorizacao;
import br.com.projetointegrador.entity.TipoUsuarioEnum;
import br.com.projetointegrador.entity.Usuario;
import br.com.projetointegrador.service.AutorizacaoService;
import br.com.projetointegrador.service.UsuarioService;
import br.com.projetointegrador.utils.Utils;
import lombok.Data;

@ManagedBean(name="cadastraFuncionarioController")
@SessionScoped
@Data
public class CadastraFuncionarioController {
	
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService ;
	
	@ManagedProperty(value="#{autorizacaoService}")
	private AutorizacaoService autorizacaoService ;
	
	private Usuario usuario;
	private String nome,telefone,email,login,senha;
	
	public void valida(){
		usuario = new Usuario();
		System.out.println("VALIDANDO FUNCIONARIO");
		
		boolean validado = true;
		if(nome.trim().equals("") || telefone.trim().equals(""))
			validado = false;
		else if(email.trim().equals("") || login.trim().equals("") || senha.trim().equals(""))
			validado = false;
		else if(Utils.verificaLetras(nome))
			validado = false;
		
		if(validado)
			salva();
		
	}
	
	private void salva(){
		try{
			senha = Utils.senhaSha256(senha);
			setarValoresUsuario();
			usuarioService.salvar(usuario);
		}catch(Exception e){
			System.out.println("Houve um erro na hora de salvar!");
		}
	}
	
	private void setarValoresUsuario(){
		List<Autorizacao> autorizacoes = new ArrayList<Autorizacao>();
		usuario.setNome(nome);
		usuario.setTipoUsuario(TipoUsuarioEnum.COORDENACAO.toString());
		usuario.setContato(telefone);
		usuario.setEmail(email);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		Autorizacao aut = autorizacaoService.buscarPorId(2);
		autorizacoes.add(aut);
		usuario.setAutorizacoes(autorizacoes);
	}
	
}
