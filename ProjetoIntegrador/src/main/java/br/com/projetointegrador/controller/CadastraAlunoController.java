package br.com.projetointegrador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.projetointegrador.entity.Autorizacao;
import br.com.projetointegrador.entity.TipoUsuarioEnum;
import br.com.projetointegrador.entity.Usuario;
import br.com.projetointegrador.service.AutorizacaoService;
import br.com.projetointegrador.service.UsuarioService;
import br.com.projetointegrador.utils.Utils;
import lombok.Data;

@ManagedBean(name="cadastraAlunoController")
@SessionScoped
@Data
public class CadastraAlunoController {
	
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;
	
	@ManagedProperty(value="#{autorizacaoService}")
	private AutorizacaoService autorizacaoService ;
	
	private Usuario usuario;
	private String nomeAluno,dataNascimento,telefoneAluno,emailAluno,ra,nomePai,nomeMae;
	private String telPai,telMae,emailResp,horario,serie,turma,login,senha;
	
	public void valida(){
		usuario = new Usuario();
		
		System.out.println("VALIDANDO CADASTRO ALUNO");
		
		boolean validado = true;
		if(nomeAluno.trim().equals("") || nomePai.trim().equals("") || nomeMae.trim().equals(""))
			validado = false;
		else if(emailAluno.trim().equals("") || dataNascimento.trim().equals("") || emailResp.trim().equals(""))
			validado = false;
		else if(ra.trim().equals("") || login.trim().equals("") || senha.trim().equals("") )
			validado = false;
		else if(turma.trim().equals("") || serie.trim().equals("") || serie.trim().equals(""))
			validado = false;
		else if(telMae.trim().equals("") || telPai.trim().equals(""))
			validado = false;
		else if(Utils.verificaLetras(this.nomeAluno) || Utils.verificaLetras(this.nomePai) || Utils.verificaLetras(this.nomeMae))
			validado = false;
			
		if(validado){
			this.salva();
		}
	}
	
	private void salva(){
		System.out.println("ESTOU SALVANDO");
		senha = Utils.senhaSha256(senha);
		setarValoresUsuario();
		usuarioService.salvar(usuario);
	}
	
	private void setarValoresUsuario(){
		List<Autorizacao> autorizacoes = new ArrayList<Autorizacao>();
		usuario.setNome(nomeAluno);
		usuario.setTipoUsuario(TipoUsuarioEnum.ALUNO.toString());
		usuario.setDataNascimento(Utils.strToDate(dataNascimento));
		usuario.setContato(telefoneAluno);
		usuario.setEmail(emailAluno);
		usuario.setRa(ra);
		usuario.setNomePai(nomePai);
		usuario.setNomeMae(nomeMae);
		usuario.setContatoPai(telPai);
		usuario.setContatoMae(telMae);
		usuario.setEmailResponsavel(emailResp);
		usuario.setHorario(horario);
		usuario.setSerie(serie);
		usuario.setTurma(turma);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		Autorizacao aut = autorizacaoService.buscarPorId(3);
		autorizacoes.add(aut);
		usuario.setAutorizacoes(autorizacoes);
	}
}
