package educa.ead.modelos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("aluno")
public class Aluno extends Usuario {

	private static final long serialVersionUID = 1L;

	@Column(name = "matricula_aluno", length = 300)
	private String matricula;
	
	
	private List<Curso> cursos = new ArrayList<>();


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public List<Curso> getCursos() {
		return cursos;
	}


	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	

}
