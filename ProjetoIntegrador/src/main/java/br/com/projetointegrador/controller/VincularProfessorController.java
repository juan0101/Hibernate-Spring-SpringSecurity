package br.com.projetointegrador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.projetointegrador.entity.Materia;
import br.com.projetointegrador.entity.TipoUsuarioEnum;
import br.com.projetointegrador.entity.Usuario;
import br.com.projetointegrador.service.UsuarioService;
import br.com.projetointegrador.utils.Utils;
import lombok.Data;

@ManagedBean(name="vincularProfessorController")
@SessionScoped
@Data
public class VincularProfessorController {
	
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;
	
	private String professorSelecionado;
	private List<String> materias;
	private List<Usuario> professores;
	private List<String> materiasSelecionadas;
	private List<SelectItem> selecaoProfessores;
	private List<SelectItem> selecaoMaterias;

	public void carregaProfessoresMaterias(){
		
		SelectItem selectProfessor;
		SelectItem materia;
		//CONSTRUÇÃO DAS LISTAS
		selecaoMaterias = new ArrayList<SelectItem>();
		selecaoProfessores = new ArrayList<SelectItem>();
		materias = new ArrayList<String>();
		professores = new ArrayList<Usuario>();
		
		//RECUPERANDO OS PROFESSORES NO BANCO DE DADOS
		professores = usuarioService.buscarTodosByTipoUsuario(TipoUsuarioEnum.PROFESSOR.toString());
		for(Usuario u: professores){
			selectProfessor = new SelectItem(u.getNome());
			selecaoProfessores.add(selectProfessor);
		}
		
		//RECUPERANDO AS MATERIAS
		materias = Utils.getTodasMaterias();
		for (String m : materias) {
			materia = new SelectItem(m);
			selecaoMaterias.add(materia);
		}
	}
	
	public void salvar(){
		List<Materia> materiasEscolhidas = new ArrayList<Materia>();
		for(String m: materiasSelecionadas){
			materiasEscolhidas.add(Utils.getMateria(m));
		}	
		Usuario profEscolhido = usuarioService.buscarUsuarioNome(professorSelecionado);
		profEscolhido.setMaterias(materiasEscolhidas);
		usuarioService.updateUsuario(profEscolhido);
	}
	
}
