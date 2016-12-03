package br.com.projetointegrador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.projetointegrador.entity.Historico;
import br.com.projetointegrador.entity.TipoUsuarioEnum;
import br.com.projetointegrador.entity.Usuario;
import br.com.projetointegrador.service.UsuarioService;
import br.com.projetointegrador.utils.Utils;
import lombok.Data;

@ManagedBean(name="historicoAlunoController")
@SessionScoped
@Data
public class HistoricoAlunoController {
	
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;
	private Historico historico;	
	
	
	public void carrega(){
		//TODO Testar e Corrigir status.
		//BUSCANDO OS ALUNOS E SETANDO NA LISTA
		//deixei a parte debaixo comentado para testar pegar direto do usuario logado
		/*List<Usuario> alunos = new ArrayList<Usuario>();
		alunos = usuarioService.buscarTodosByTipoUsuario(TipoUsuarioEnum.ALUNO.toString());*/
		//if(!alunos.isEmpty()){
			//TODO CASO A LISTA NÃO ESTIVER VAZIA
		Usuario usuario_logado = Utils.getUsuarioLogado();
		if(usuario_logado != null){
//			this.historico = new Historico(usuario_logado.getMaterias(), usuario_logado.getAno()
//				, usuario_logado.getNotas(), usuario_logado.getFaltas(), true);
		}
		/*}else{
			//TODO CASO A LISTA ESTEJA NULA OU VAZIA
		}*/
		
		//setar valores
	}
	
}