package br.com.projetointegrador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.projetointegrador.entity.Aviso;
import br.com.projetointegrador.entity.TipoUsuarioEnum;
import br.com.projetointegrador.entity.Usuario;
import br.com.projetointegrador.service.UsuarioService;
import lombok.Data;

@ManagedBean(name="avisosAlunoController")
@SessionScoped
@Data
public class AvisosAlunoController {
	
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;
	private Aviso avisos[];
	
	public void carrega(){
		
		//BUSCANDO OS ALUNOS E SETANDO NA LISTA
		List<Usuario> alunos = new ArrayList<Usuario>();
		alunos = usuarioService.buscarTodosByTipoUsuario(TipoUsuarioEnum.ALUNO.toString());
		if(!alunos.isEmpty()){
			//TODO CASO A LISTA NÃO ESTIVER VAZIA
		}else{
			//TODO CASO A LISTA ESTEJA NULA OU VAZIA
		}
		
		//TODO setar valores
	}
	
}

