package br.com.projetointegrador.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="aviso")
public class Aviso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Temporal(TemporalType.DATE)
	@Column(name="data", nullable=true)
	private Date data;
	@Column(name="remetente")
	private String remetente;
	@Column(name="destinatario")
	private String destinatario;
	@Column(name="aviso")
	private String aviso;
	
}
