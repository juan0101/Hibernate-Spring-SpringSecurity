package br.com.projetointegrador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.projetointegrador.entity.Disciplina;
import br.com.projetointegrador.entity.TipoUsuarioEnum;
import br.com.projetointegrador.entity.Usuario;
import br.com.projetointegrador.service.UsuarioService;
import br.com.projetointegrador.utils.Utils;
import lombok.Data;

@ManagedBean(name="disciplinasAlunoController")
@SessionScoped
@Data
public class DisciplinasAlunoController {
	
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;
	private Disciplina disciplinas[];	
	public void carrega(){

		Usuario usuario_logado = Utils.getUsuarioLogado();
		if(usuario_logado != null){
			//TODO fazer o set de disciplinas e faltas
		}
		
		//BUSCANDO OS ALUNOS E SETANDO NA LISTA
		/*List<Usuario> alunos = new ArrayList<Usuario>();
		alunos = usuarioService.buscarTodosByTipoUsuario(TipoUsuarioEnum.ALUNO.toString());
		if(!alunos.isEmpty()){
			//TODO CASO A LISTA NÃO ESTIVER VAZIA
		}else{
			//TODO CASO A LISTA ESTEJA NULA OU VAZIA
		}*/
		
		//setar valores
	}
	
}