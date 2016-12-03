package br.com.projetointegrador.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.projetointegrador.entity.Usuario;
import br.com.projetointegrador.utils.Utils;
import lombok.Data;

@ManagedBean(name="carregaUsuarioLogadoController")
@SessionScoped
@Data
public class CarregaUsuarioLogadoController {
	
	private String nomeUsuarioTela;
	
	public void carregarUsuario(){
		Usuario usuario = null;
		usuario = Utils.getUsuarioLogado();
		if(usuario != null){
			nomeUsuarioTela = usuario.getLogin();
		}else{
			nomeUsuarioTela = "Não logado";
		}
		
	}

}
