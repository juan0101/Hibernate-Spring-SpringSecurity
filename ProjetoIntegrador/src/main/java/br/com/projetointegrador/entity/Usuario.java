package br.com.projetointegrador.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements UserDetails{
	
	private static final long serialVersionUID = -4644167353738297546L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/*
	 * DADOS GERAIS
	 */
	@Column(name="nome")
	private String nome;
	@Column(name="contato")
	private String contato;
	@Column(name="email")
	private String email;
	@Column(name="login")
	private String login;
	@Column(name="senha")
	private String senha;
	@Column(name="tipo_usuario")
	private String tipoUsuario;
	
	/*
	 * DADOS DO PROFESSOR
	 */
	@Column(name="endereco")
	private String endereco;
	@Column(name="bairro")
	private String bairro;
	@Column(name="cep")
	private String cep;
	@Column(name="numero")
	private String numero;
	@Column(name="registro_professor")
	private String registro;
	
	@ElementCollection(targetClass=Materia.class, fetch=FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="professor_materia")
    @Column(name="materias")
    Collection<Materia> materias;
	
	/*
	 * DADOS DA COORDENACAO
	 * TODOS OS DADOS NECESSARIOS ESTAO NO DADOS GERAIS
	 */
	
	/*
	 * DADOS DO ALUNO
	 */
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento", nullable=true)
	private Date dataNascimento;
	@Column(name="ra")
	private String ra;
	@Column(name="nome_pai")
	private String nomePai;
	@Column(name="contato_pai")
	private String contatoPai;
	@Column(name="nome_mae")
	private String nomeMae;
	@Column(name="contato_mae")
	private String contatoMae;
	@Column(name="email_responsavel")
	private String emailResponsavel;
	@Column(name="horario")
	private String horario;
	@Column(name="turma")
	private String turma;
	@Column(name="serie")
	private String serie;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USUARIO_AUTORIZACAO", 
    	joinColumns = { @JoinColumn(name = "USUARIO_ID") }, 
    	inverseJoinColumns = { @JoinColumn(name = "AUT_ID") })
    private List<Autorizacao> autorizacoes;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return autorizacoes;
	}

	@Override
	public String getPassword() {return senha;}

	@Override
	public String getUsername() {return nome;}

	@Override
	public boolean isAccountNonExpired() {return true;}

	@Override
	public boolean isAccountNonLocked() {return true;}

	@Override
	public boolean isCredentialsNonExpired() {return true;}

	@Override
	public boolean isEnabled() {return true;}
	
	
}
