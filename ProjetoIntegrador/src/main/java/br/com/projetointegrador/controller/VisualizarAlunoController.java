package br.com.projetointegrador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.projetointegrador.entity.TipoUsuarioEnum;
import br.com.projetointegrador.entity.Usuario;
import br.com.projetointegrador.service.UsuarioService;
import br.com.projetointegrador.serviceImpl.UsuarioServiceImpl;
import lombok.Data;

@ManagedBean(name="visualizarAlunosController")
@SessionScoped
@Data
public class VisualizarAlunoController {
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;
	private List<Usuario> alunos ;
	 
	
	public void carregaAlunos(){
		this.alunos = new ArrayList<Usuario>();
		this.alunos = this.usuarioService.buscarTodosByTipoUsuario(TipoUsuarioEnum.ALUNO.toString());
		//System.out.println(this.alunos.size());
	}
	
	
}
