package educa.ead.modelos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity()
@DiscriminatorValue(value = "aluno")
public class Aluno extends Usuario {
	
	@Column(name = "matricula_aluno" , length = 300)
	private String matricula;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "Aluno" , orphanRemoval = true)
	private List<Curso> cursos = new ArrayList<>(); 
	
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public List<Curso> getCursos() {
		return cursos;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + "]";
	}
	
	
	
	
	
}
