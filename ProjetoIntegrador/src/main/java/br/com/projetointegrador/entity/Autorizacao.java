package br.com.projetointegrador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
@Entity
@Table(name="AUTORIZACAO")
public class Autorizacao implements GrantedAuthority{
	
	
	private static final long serialVersionUID = 5741475011177502501L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="aut_id")
	private int id;
	@Column(name="aut_nome")
	private String nome;
	
	
	@Override
	public String getAuthority() {
		return nome;
	}
	
}
