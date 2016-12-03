package br.com.projetointegrador.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.projetointegrador.*;
import br.com.projetointegrador.entity.Usuario;
import lombok.Data;

@ManagedBean(name="lancarNotasController")
@SessionScoped
@Data
public class LancarNotasController {
	
	private String serie_selecionada;
	private String turma_selecionada;
	private String horario_selecionado;
	private Usuario[] usuarios;

	public void buscar(){
//		this.usarios = UsuarioServiceImpl.buscarTodosByTipoUsuario(TipoUsuarioEnum.ALUNO.toString());
//		//TODO busca dos usuarios
	}

	public void salvar(){
		//TODO salvar
	}
	
}
