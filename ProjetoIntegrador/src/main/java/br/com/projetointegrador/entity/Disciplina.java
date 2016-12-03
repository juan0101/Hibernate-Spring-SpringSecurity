package br.com.projetointegrador.entity;

import lombok.Data;

@Data
public class Disciplina {
	
	private Materia materias;
	private Integer faltas;

	public Disciplina(Materia materias, Integer faltas){
		this.materias = materias;
		this.faltas = faltas;
	}

}
