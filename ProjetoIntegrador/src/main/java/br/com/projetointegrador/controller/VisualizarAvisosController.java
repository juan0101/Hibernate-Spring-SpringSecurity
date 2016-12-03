package br.com.projetointegrador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.projetointegrador.entity.Aviso;
import br.com.projetointegrador.entity.Usuario;
import br.com.projetointegrador.service.AvisoService;
import br.com.projetointegrador.utils.Utils;
import lombok.Data;

@ManagedBean(name="visualizarAvisosController")
@SessionScoped
@Data
public class VisualizarAvisosController {
	
	@ManagedProperty(value="#{avisoService}")
	private AvisoService avisoService;
	
	private List<Aviso> mensagens ;
	private Usuario usuario_logado; 
	
	public void carregaAvisos(){
		this.usuario_logado = Utils.getUsuarioLogado();
		this.mensagens = new ArrayList<Aviso>();
		this.mensagens = this.avisoService.buscarAvisos(usuario_logado.getNome());
	}
	
	
}
