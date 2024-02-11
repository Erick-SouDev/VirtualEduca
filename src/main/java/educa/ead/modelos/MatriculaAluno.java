package educa.ead.modelos;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", initialValue = 1000, allocationSize = 1)
@SecondaryTable(name = "aluno", pkJoinColumns = @PrimaryKeyJoinColumn(name = "aluno_id") )
@SecondaryTable(name = "curso", pkJoinColumns = @PrimaryKeyJoinColumn(name = "curso_id"))

public class MatriculaAluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq_matricula")
	private Long id;

	private Date quandoFoiMatriculado;
	
	@ManyToOne(cascade = CascadeType.ALL ,optional =  true , fetch = FetchType.EAGER)
	@JoinColumn(name = "id_aluno" ,referencedColumnName = "id" , table = "Aluno")
	private Aluno aluno;
	
	
	@ManyToOne(cascade = CascadeType.ALL ,optional =  true , fetch = FetchType.EAGER)
	@JoinColumn(name = "id_curso" ,referencedColumnName = "id" , table = "Curso")
	private Curso curso;


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaAluno other = (MatriculaAluno) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "MatriculaAluno [id=" + id + ", quandoFoiMatriculado=" + quandoFoiMatriculado + ", aluno=" + aluno
				+ ", curso=" + curso + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


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
