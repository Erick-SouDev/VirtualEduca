package educa.ead.modelos;

import java.util.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_aluno_inscrito_curso", uniqueConstraints = @UniqueConstraint(columnNames = { "aluno", "curso" }))

public class AlunoInscritoCurso {

	@Temporal(TemporalType.DATE)
	private Date quandoFoiMatriculado;

	@EmbeddedId
	private CursoAluno cursoAluno;

	public Date getQuandoFoiMatriculado() {
		return quandoFoiMatriculado;
	}

	public void setQuandoFoiMatriculado(Date quandoFoiMatriculado) {
		this.quandoFoiMatriculado = quandoFoiMatriculado;
	}

	public CursoAluno getCursoAluno() {
		return cursoAluno;
	}

	public void setCursoAluno(CursoAluno cursoAluno) {
		this.cursoAluno = cursoAluno;
	}


}
