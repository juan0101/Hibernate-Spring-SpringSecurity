package br.com.projetointegrador.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.projetointegrador.entity.Aviso;
import br.com.projetointegrador.entity.TipoUsuarioEnum;
import br.com.projetointegrador.entity.Usuario;
import br.com.projetointegrador.service.AvisoService;
import br.com.projetointegrador.service.UsuarioService;
import br.com.projetointegrador.utils.Utils;
import lombok.Data;

@ManagedBean(name="enviarAvisoController")
@SessionScoped
@Data
public class EnviarAvisoController {
	
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;
	
	@ManagedProperty(value="#{avisoService}")
	private AvisoService avisoService;
	
	private Aviso aviso ;
	private Usuario usuario_logado; 
	private String mensagem;
	private String alunoSelecionado;
	private String professorRemetente;
	
	private List<Usuario> alunos;
	private List<SelectItem> itemsAlunos;
	
	public void iniciar(){
		aviso = new Aviso();
		//CAPTURANDO O USUARIO LOGADO
		usuario_logado = Utils.getUsuarioLogado();
		
		SelectItem alunoItem;
		alunos = new ArrayList<Usuario>();
		itemsAlunos = new ArrayList<SelectItem>();
		//CAPTURANDO OS ALUNOS DO BANCO
		alunos = usuarioService.buscarTodosByTipoUsuario(TipoUsuarioEnum.ALUNO.toString());
		for(Usuario u: alunos){
			alunoItem = new SelectItem(u.getNome());
			itemsAlunos.add(alunoItem);
		}
		
	}

	public void enviar(){
		alimentarAviso();
	    avisoService.salvar(aviso);
	    
	    limparAviso();
	}
	
	public void limparAviso(){
		mensagem = "";
	}

	private void alimentarAviso() {
		aviso.setData(new Date());
		aviso.setDestinatario(alunoSelecionado);
		aviso.setRemetente(usuario_logado.getNome());
		aviso.setAviso(mensagem);
	}
	
	
}
