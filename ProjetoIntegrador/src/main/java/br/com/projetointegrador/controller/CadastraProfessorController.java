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

@ManagedBean(name="cadastraProfessorController")
@SessionScoped
@Data
public class CadastraProfessorController {
	
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;
	
	@ManagedProperty(value="#{autorizacaoService}")
	private AutorizacaoService autorizacaoService ;
	
	private Usuario usuario;
	private String nome,endereco,numero,bairro,cep,telefone,email,numRegistro,login,senha;
	
	public void valida(){
		usuario = new Usuario();
		System.out.println("VALINDANDO");
		
		boolean validado = true;
		if(nome.trim().equals("") || endereco.trim().equals("")|| numero.trim().equals(""))
			validado = false;
		else if(bairro.trim().equals("") || cep.trim().equals("") || telefone.trim().equals(""))
			validado = false;
		else if(email.trim().equals("") || numRegistro.trim().equals("") || login.trim().equals("") || senha.trim().equals(""))
			validado = false;
		else if(Utils.verificaLetras(nome))
			validado = false;
		
		System.out.println(validado);
		
		if(validado)
			salva();
		
	}
	
	private void salva(){
		try{
			System.out.println("SALVANDO PROFESSOR");
			senha = Utils.senhaSha256(senha);
			setarValoresUsuario();
			usuarioService.salvar(usuario);
			limparTela();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void limparTela(){
		nome = "";
		endereco = "";
		numero = "";
		bairro = "";
		cep = "";
		telefone = "";
		email = "";
		numRegistro = "";
		login = "";
		senha = "";
	}
	
	private void setarValoresUsuario(){
		List<Autorizacao> autorizacoes = new ArrayList<Autorizacao>();
		usuario.setTipoUsuario(TipoUsuarioEnum.PROFESSOR.toString());
		usuario.setNome(nome);
		usuario.setEndereco(endereco);
		usuario.setBairro(bairro);
		usuario.setCep(cep);
		usuario.setNumero(numero);
		usuario.setContato(telefone);
		usuario.setEmail(email);
		usuario.setRegistro(numRegistro);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		Autorizacao aut = autorizacaoService.buscarPorId(4);
		autorizacoes.add(aut);
		usuario.setAutorizacoes(autorizacoes);
	}
	
}
