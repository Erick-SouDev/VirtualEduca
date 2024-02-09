package educa.ead.modelos;

import org.hibernate.annotations.ForeignKey;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;

@Embeddable
public class AlunoCurso {
    
	@JoinColumn(name = "id_aluno")
	@ForeignKey(name = "id_aluno_fk")
	private Aluno aluno;
	
	@JoinColumn(name = "id_curso")
	@ForeignKey(name = "id_curso_fk")
	private Curso curso;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
