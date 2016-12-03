package br.com.projetointegrador.entity;

import lombok.Data;

@Data
public class Historico {
	
	private Materia materias[];
	private Integer ano;
	private Double notas[];
	private Integer faltas[];
	private String status;

	public Historico(Materia materias[], Integer ano, Double notas[], Integer faltas[], String status){
		this.materias = materias;
		this.ano = ano;
		this.notas = notas;
		this.faltas = faltas;
		this.status = status;
	}

}
