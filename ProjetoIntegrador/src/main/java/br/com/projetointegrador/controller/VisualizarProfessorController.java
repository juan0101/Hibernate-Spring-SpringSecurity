package br.com.projetointegrador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.projetointegrador.entity.TipoUsuarioEnum;
import br.com.projetointegrador.entity.Usuario;
import br.com.projetointegrador.service.UsuarioService;
import lombok.Data;

@ManagedBean(name="visualizarProfessorController")
@SessionScoped
@Data
public class VisualizarProfessorController {
	
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;
	
	private List<Usuario> professores ;
	 
	
	public void carregaProfessores(){
		this.professores = new ArrayList<Usuario>();
		this.professores = this.usuarioService.buscarTodosByTipoUsuario(TipoUsuarioEnum.PROFESSOR.toString());
		System.out.println(this.professores.size());
	}
	
	
}
