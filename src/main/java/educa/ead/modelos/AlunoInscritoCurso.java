package educa.ead.modelos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class AlunoInscritoCurso {

	@Temporal(TemporalType.DATE )
	private Date quandoFoiMatriculado;
	
	@Embedded
	private AlunoCurso alunoCurso;

	public Date getQuandoFoiMatriculado() {
		return quandoFoiMatriculado;
	}

	public void setQuandoFoiMatriculado(Date quandoFoiMatriculado) {
		this.quandoFoiMatriculado = quandoFoiMatriculado;
	}

	public AlunoCurso getAlunoCurso() {
		return alunoCurso;
	}

	public void setAlunoCurso(AlunoCurso alunoCurso) {
		this.alunoCurso = alunoCurso;
	}

	@Override
	public String toString() {
		return "AlunoInscritoCurso [quandoFoiMatriculado=" + quandoFoiMatriculado + ", alunoCurso=" + alunoCurso + "]";
	}


	
	
	
	
	
}
