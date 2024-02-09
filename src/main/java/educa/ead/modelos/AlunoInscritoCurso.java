package educa.ead.modelos;

import java.util.Date;

import org.hibernate.annotations.ForeignKey;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class AlunoInscritoCurso {

	@Temporal(TemporalType.DATE )
	private Date quandoFoiMatriculado;
	

	@JoinColumn(name = "id_aluno")
	@ForeignKey(name = "id_aluno_fk")
	private Aluno aluno;
	
	
	@JoinColumn(name = "id_curso")
	@ForeignKey(name = "id_curso_fk")
	private Curso curso;


	public Date getQuandoFoiMatriculado() {
		return quandoFoiMatriculado;
	}


	public void setQuandoFoiMatriculado(Date quandoFoiMatriculado) {
		this.quandoFoiMatriculado = quandoFoiMatriculado;
	}


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
