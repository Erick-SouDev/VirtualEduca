package educa.ead.modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "aluno_curso" , uniqueConstraints = @UniqueConstraint(columnNames = {"id_aluno" , "id_curso" } ))
public class AlunoCurso implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "data_matricula")
	@Temporal(TemporalType.DATE)
	private Date dataMatricula;
	
	@EmbeddedId
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "id_aluno_fk" , value = ConstraintMode.CONSTRAINT) , name = "id_aluno")
	private Aluno aluno;
	
	
	@EmbeddedId
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "id_cursofk" , value = ConstraintMode.CONSTRAINT) , name = "id_curso")
	private Curso curso;
	
	@Override
	public String toString() {
		return "AlunoCurso [dataMatricula=" + dataMatricula + ", aluno=" + aluno + ", curso=" + curso + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, curso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoCurso other = (AlunoCurso) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(curso, other.curso);
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
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
